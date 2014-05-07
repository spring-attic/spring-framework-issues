package org.springframework.issues;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.internal.AssumptionViolatedException;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.issues.filter.HttpDumperFilter;
import org.springframework.issues.filter.HttpStatusOverrideFilter;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebAppConfiguration
@ActiveProfiles("dev")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/spring/context.xml")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GateControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(GateControllerTest.class);

    @Autowired
    private WebApplicationContext webApplicationContext;
    //
    private MockMvc mockMvcWithOnlyOneFilter;
    //
    private MockMvc firstMockMvcWithTwoFilters;
    //
    private MockMvc secondMockMvcWithTwoFilters;

    @Rule
    public TestRule watcher = new MyTestWatcher();

    @Before
    public void setup() throws Exception {
        //
        mockMvcWithOnlyOneFilter = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilters(new HttpStatusOverrideFilter()).build();
        //
        firstMockMvcWithTwoFilters = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilters(new HttpDumperFilter(), new HttpStatusOverrideFilter()).build();
        //
        secondMockMvcWithTwoFilters = MockMvcBuilders.webAppContextSetup(webApplicationContext)
                .addFilters(new HttpStatusOverrideFilter(), new HttpDumperFilter()).build();
    }

    @Test
    public void failedTestWithOnlyOneFilter() throws Exception {
        mockMvcWithOnlyOneFilter.perform(post("/invalid-request-uri")).andExpect(status().is(equalTo(230)));
    }

    @Test
    public void firstPassedTestWithTwoFilters() throws Exception {
        firstMockMvcWithTwoFilters.perform(post("/invalid-request-uri")).andExpect(status().is(equalTo(230)));
    }

    @Test
    public void secondPassedTestWithTwoFilters() throws Exception {
        secondMockMvcWithTwoFilters.perform(post("/invalid-request-uri")).andExpect(status().is(equalTo(230)));
    }

    private static class MyTestWatcher extends TestWatcher {
        @Override
        protected void starting(Description description) {
            logger.info("--------------------------------------------------------------------------------------------");
            logger.info("Starting {}", description.getDisplayName());
        }

        @Override
        protected void succeeded(Description description) {
            logger.info("--------------------------------------------------------------------------------------------");
            logger.info("Succeeded {}", description.getDisplayName());
        }

        @Override
        protected void failed(Throwable e, Description description) {
            logger.info("--------------------------------------------------------------------------------------------");
            logger.info("Failed {}", description.getDisplayName());
        }

        @Override
        protected void skipped(AssumptionViolatedException e, Description description) {
            logger.info("--------------------------------------------------------------------------------------------");
            logger.info("Skipped {}", description.getDisplayName());
        }
    }
}

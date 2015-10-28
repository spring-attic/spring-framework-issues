package org.springframework.issues;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.asyncDispatch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = RootConfiguration.class)
public class ReproTests {

    @Autowired
    private WebApplicationContext wac;

    @Autowired
    private IgnoredCallableInterceptor callableInterceptor;

    @Autowired
    private IgnoredDeferredResultInterceptor deferredResultInterceptor;

    private MockMvc mockMvc;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(wac)
            .build();
    }

    @Test
    public void repro() throws Exception {
        MvcResult r = mockMvc.perform(get("/dummyCallable"))
            .andExpect(request().asyncStarted())
            .andReturn();
        mockMvc.perform(asyncDispatch(r))
            .andExpect(status().isOk());
        assertTrue(callableInterceptor.executed.get());
    }

    @Test
    public void repro2() throws Exception {
        MvcResult r = mockMvc.perform(get("/dummyDeferred"))
            .andExpect(request().asyncStarted())
            .andReturn();
        mockMvc.perform(asyncDispatch(r))
            .andExpect(status().isOk());
        assertTrue(callableInterceptor.executed.get());
    }

}

package org.springframework.issues;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.issues.config.WebConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfig.class)
public class TestControllerTests {

    @Autowired
    private WebApplicationContext wac;

    MockMvc mvc;

    @Before
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void contextLoads() {
    }

    @Test
    public void doTheThingShouldDoTheThing() throws Exception {
        mvc.perform(
                get("/do-the-thing?otherParameter=a&thingIds=123")
        ).andExpect(status().isOk());
    }

    /**
     * Here to ensure that simple validation is running.
     */
    @Test
    public void shouldRaise400IfSimpleValidationFails() throws Exception {
        mvc.perform(
                get("/do-the-thing?otherParameter=abcd&thingIds=123")
        ).andExpect(status().isBadRequest());
    }

    @Test
    public void shouldRaise400IfNestedValidationFails() throws Exception {
        mvc.perform(
                get("/do-the-thing?otherParameter=a&thingIds=invalidnonsense")
        ).andExpect(status().isBadRequest());
    }

}

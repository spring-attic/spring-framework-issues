package org.springframework.issues;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @author cartedan
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({ "file:src/main/webapp/WEB-INF/spring/servlet-context.xml" })
@WebAppConfiguration
public class ControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @Before
    public void setUp(){
        mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
    }

    @Test
    public void voidTestNotEncodingInTestCase() throws Exception {

        // GIVEN
        String id = "a/b";

        // WHEN - circuit viewed
        ResultActions result = mockMvc.perform(get("/circuit/{id}", id));

        // THEN - circuit should be in the model
        result.andExpect(status().isOk()).andExpect(model().attribute("receivedId", is(id)));

    }

    @Test
    public void voidTestEncodingInTestCase() throws Exception {

        // GIVEN
        String id = "a%2Fb";

        // WHEN - circuit viewed
        ResultActions result = mockMvc.perform(get("/circuit/{id}", id));

        // THEN - circuit should be in the model
        result.andExpect(status().isOk()).andExpect(model().attribute("receivedId", is("a/b")));

    }

}

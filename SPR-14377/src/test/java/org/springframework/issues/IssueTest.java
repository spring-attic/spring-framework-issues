package org.springframework.issues;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.ConfigurableWebApplicationContext;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = "file:src/main/webapp/WEB-INF/spring/*-context.xml")
public class IssueTest
{
    @Autowired
    private ConfigurableWebApplicationContext context;

    private final String examplePage = "/example/page";
    private final String noexist = "/example/noexist";

    @Test
    public void test() throws Throwable
    {
        assertNotNull(context);

        //Assert we have a controller!
        assertTrue(context.getBeanNamesForAnnotation(Controller.class).length > 0);

        MockMvc mockMvc = MockMvcBuilders.webAppContextSetup(context).build();

        //Expect 200 because I request a forward
        mockMvc.perform(post("/example/go").accept(MediaType.ALL).contentType(MediaType.APPLICATION_FORM_URLENCODED).param("forward", examplePage))
               .andExpect(status().is2xxSuccessful());

        //Expect 300 because it is a redirect
        mockMvc.perform(post("/example/go").accept(MediaType.ALL).contentType(MediaType.APPLICATION_FORM_URLENCODED).param("redirect", examplePage))
               .andExpect(status().is3xxRedirection());

        //Expect a 404 because page does not exist
        mockMvc.perform(post("/example/go").accept(MediaType.ALL).contentType(MediaType.APPLICATION_FORM_URLENCODED).param("forward", noexist))
               .andExpect(status().is4xxClientError());

        //Expect 300 because we don't know yet that the page does not exist
        mockMvc.perform(post("/example/go").accept(MediaType.ALL).contentType(MediaType.APPLICATION_FORM_URLENCODED).param("redirect", noexist))
               .andExpect(status().is3xxRedirection());

    }

}

package org.springframework.issues;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ReproTests {
    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    public void testInputJson() throws Exception {
        // Works fine, matches post1()
        this.mockMvc.perform(post("/test")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @Test
    public void testInputText() throws Exception {
        // Works fine, matches post2()
        this.mockMvc.perform(post("/test")
            .contentType(MediaType.TEXT_PLAIN)
            .accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @Test
    public void testInputJsonBadAccept() throws Exception {
        // Mismatches post1() by specifying an invalid Accept header but a valid Content-Type header
        this.mockMvc.perform(post("/test")
            .contentType(MediaType.APPLICATION_JSON)
            .accept(MediaType.APPLICATION_XML))
            .andExpect(status().isNotAcceptable());
    }

    @Test
    public void testInputTextBadAccept() throws Exception {
        // Mismatches post2() by specifying an invalid Accept header but a valid Content-Type header
        this.mockMvc.perform(post("/test")
            .contentType(MediaType.TEXT_PLAIN)
            .accept(MediaType.APPLICATION_XML))
            .andExpect(status().isNotAcceptable());
    }
}

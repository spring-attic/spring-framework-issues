package org.springframework.issues;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class TestControllerTest {

    private MockMvc mockMvc;

    @Before
    public void prepare() {
        mockMvc = MockMvcBuilders.standaloneSetup(new TestController()).setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
    }

    @Test
    public void shouldSend201WhenNoContentTypeAndNoRequestBody() throws Exception {
        mockMvc.perform(post("/testjson").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isCreated());
    }

    @Test
    public void shouldSend201WhenContentTypeSpecifiedAndNoRequestBody() throws Exception {
        mockMvc.perform(post("/testjson").accept(MediaType.APPLICATION_JSON).contentType(MediaType.APPLICATION_JSON))
               .andExpect(status().isCreated());
    }
}

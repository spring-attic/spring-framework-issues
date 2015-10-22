package org.springframework.issues;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

public class TestControllerTest {

    private MockMvc mockMvc;

    @Before
    public void prepare() {
        mockMvc = MockMvcBuilders
                .standaloneSetup(new TestController()).setMessageConverters(new MappingJackson2HttpMessageConverter())
                .build();
    }

    @Test
    public void shouldSend200WithValidPayload() throws Exception {
        mockMvc.perform(post("/mandatory-body").content("{\"message\":\"spring\"}").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string("\"hello\""));
    }

    @Test
    public void shouldSend400WithEmptyBody() throws Exception {
        mockMvc.perform(post("/mandatory-body")).andExpect(status().isBadRequest());
    }

    @Test
    public void shouldSend400WithEmptyJsonObject() throws Exception {
        mockMvc.perform(post("/mandatory-body").content("{}").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldSend400WithNullJsonObject() throws Exception {
        mockMvc.perform(post("/mandatory-body").content("null").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void shouldSend200WithNullJsonObject() throws Exception {
        mockMvc.perform(post("/optional-body").content("null").contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
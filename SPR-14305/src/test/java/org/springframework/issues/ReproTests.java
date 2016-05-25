package org.springframework.issues;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.issues.config.WebConfig;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.RequestPostProcessor;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = WebConfig.class)
@WebAppConfiguration
public class ReproTests {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @Before
    public void setupMockMvc() {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();
    }

    @Test
    public void rfc3986() throws Exception {
        final String host = "spring_app"; // RFC 3986 allow '_'. However tests is fail.
        mockMvc.perform(get("/")
                .with(host(host))
                .header(HttpHeaders.ORIGIN, host))
                .andExpect(view()
                        .name("home"));
    }


    @Test
    public void rfc2396() throws Exception {
        String host = "spring-app"; // RFC 2396 does not allow '_'. Therefor i use a host name include with "-" instead of "_".
        mockMvc.perform(get("/")
                .with(host(host))
                .header(HttpHeaders.ORIGIN, host))
                .andExpect(view()
                        .name("home"));
    }

    private RequestPostProcessor host(final String host) {
        return new RequestPostProcessor() {
            public MockHttpServletRequest postProcessRequest(MockHttpServletRequest request) {
                request.setServerName(host);
                return request;
            }
        };
    }

}

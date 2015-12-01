package org.springframework.issues.spr13733.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.test.web.client.MockMvcClientHttpRequestFactory;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class MockClientHttpRequestFactoryConfiguration {

    @Autowired
    protected WebApplicationContext wac;

    @Bean
    public ClientHttpRequestFactory clientHttpRequestFactory() {
        final MockMvc mockMvc = MockMvcBuilders
            .webAppContextSetup(this.wac)
            .build();
        return new MockMvcClientHttpRequestFactory(mockMvc);
    }

}

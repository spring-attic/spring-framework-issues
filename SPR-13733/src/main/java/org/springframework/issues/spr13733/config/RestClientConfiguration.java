package org.springframework.issues.spr13733.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestClientConfiguration {

    @Autowired
    private ClientHttpRequestFactory clientHttpRequestFactory;

    @Bean
    public RestOperations restOperations() {
        final RestTemplate restTemplate = new RestTemplate();
        restTemplate.setRequestFactory(clientHttpRequestFactory);
        return restTemplate;
    }
}

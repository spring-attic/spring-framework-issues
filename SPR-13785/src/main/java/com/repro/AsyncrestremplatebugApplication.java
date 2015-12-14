package com.repro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.AsyncRestTemplate;

@SpringBootApplication
public class AsyncrestremplatebugApplication {

    public static void main(String[] args) {
        SpringApplication.run(AsyncrestremplatebugApplication.class, args);
    }
    
    @Bean
    public AsyncRestTemplate asyncRestTemplate() throws Exception {
        AsyncRestTemplate restTemplate = new AsyncRestTemplate();
        return restTemplate;
    }

}

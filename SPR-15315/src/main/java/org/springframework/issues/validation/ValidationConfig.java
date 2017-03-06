package org.springframework.issues.validation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
public class ValidationConfig {

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        MethodValidationPostProcessor methodValidationPostProcessor = new MethodValidationPostProcessor();
        methodValidationPostProcessor.setOrder(1000);
        // methodValidationPostProcessor.setBeforeExistingAdvisors(true); // Fix for the current problem.
        return methodValidationPostProcessor;
    }

    @Bean
    public CustomerService userCreateService() {
        return new CustomerService();
    }
}
package org.springframework.issues;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
@ComponentScan
@EnableAsync
public class MyConfiguration {

    @Bean
    public MethodValidationPostProcessor methodValidationPostProcessor() {
        final MethodValidationPostProcessor methodValidationPostProcessor;

        methodValidationPostProcessor = new MethodValidationPostProcessor();
        methodValidationPostProcessor.setOrder(Ordered.HIGHEST_PRECEDENCE);

        return methodValidationPostProcessor;
    }
}

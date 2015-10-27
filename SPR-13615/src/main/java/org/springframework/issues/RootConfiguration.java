package org.springframework.issues;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan
public class RootConfiguration extends WebMvcConfigurerAdapter {

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.registerCallableInterceptors(getIgnoredCallableInterceptor());
        configurer.registerDeferredResultInterceptors(ignoredDeferredResultInterceptor());
    }

    @Bean
    public IgnoredCallableInterceptor getIgnoredCallableInterceptor() {
        return new IgnoredCallableInterceptor();
    }

    @Bean
    public IgnoredDeferredResultInterceptor ignoredDeferredResultInterceptor() {
        return new IgnoredDeferredResultInterceptor();
    }
}

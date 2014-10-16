package org.springframework.issues.config;

import org.slf4j.Logger;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;

@Configuration
@ComponentScan(basePackages = "org.springframework.issues", excludeFilters = {
        @Filter(Controller.class),
        @Filter(type = FilterType.ASSIGNABLE_TYPE, value = WebConfig.class) })
public class AppRootConfig {
    @SuppressWarnings("unused")
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(AppRootConfig.class);
}

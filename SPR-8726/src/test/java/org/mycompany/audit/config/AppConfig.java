package org.mycompany.audit.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;

@Configuration
@ComponentScan(basePackages = "org.mycompany.audit", excludeFilters = @Filter(type = FilterType.ANNOTATION, value = Configuration.class))
@Profile("UNIT_TEST")
@ImportResource("classpath:aop.xml")
public class AppConfig
{
}

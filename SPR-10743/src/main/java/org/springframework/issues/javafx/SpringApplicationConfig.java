package org.springframework.issues.javafx;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/spring-client-security.xml")
@ComponentScan(basePackages = { "org.springframework.issues.javafx.controller", "org.springframework.issues.beans" })
public class SpringApplicationConfig {

}
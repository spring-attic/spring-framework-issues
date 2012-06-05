package org.springframework.issues.config.java_centric;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.issues.config.RepositoryConfig;

@Configuration
@ImportResource("classpath:org/springframework/issues/config/java_centric/app-config.xml")
@Import(RepositoryConfig.class)
@ComponentScan(basePackages="org.springframework.issues.service")
public class AppConfig {
}

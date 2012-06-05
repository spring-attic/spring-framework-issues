package org.springframework.issues.config.xml_centric;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.issues.config.RepositoryConfig;

@Configuration
@Import(RepositoryConfig.class)
@ComponentScan(basePackages="org.springframework.issues.service")
public class AppConfig {
}

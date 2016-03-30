package org.springframework.issues;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.web.config.SpringDataWebConfiguration;

@Import(SpringDataWebConfiguration.class)
@Configuration
public class SpringDataConfig {
}

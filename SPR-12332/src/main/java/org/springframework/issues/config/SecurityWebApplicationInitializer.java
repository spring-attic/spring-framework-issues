package org.springframework.issues.config;

import org.slf4j.Logger;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

@Order(1)
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {
    @SuppressWarnings("unused")
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger(SecurityWebApplicationInitializer.class);

}

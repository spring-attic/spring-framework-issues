package org.springframework.issues;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Aspect
public class ComponentAspect {
    private static final Logger log = LoggerFactory.getLogger(ComponentAspect.class);

    @Before("@annotation(org.springframework.issues.AdivseMe) && this(c)")
    public void doSomething(ScopedComponent c) {
        log.info("Doing something");
        c.setGreeting("Welcome");
    }
}

package org.springframework.issues;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

public class NonDisposableBean implements InitializingBean {

    protected final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("Created: {}", getClass() );
    }
}

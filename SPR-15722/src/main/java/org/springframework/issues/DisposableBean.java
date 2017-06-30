package org.springframework.issues;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;

/**
 * Created by marten on 30-06-17.
 */
public class DisposableBean implements InitializingBean, org.springframework.beans.factory.DisposableBean{

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void destroy() throws Exception {
        logger.info("Destroyed: {}", getClass());
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        logger.info("Created: {}", getClass());
    }
}

package org.springframework.issues.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


public class StartupListener implements ServletContextListener {

    private static final Logger logger = LoggerFactory.getLogger(StartupListener.class);

    @Override @SuppressWarnings("HardCodedStringLiteral")
    public void contextInitialized(ServletContextEvent event) {
        ServletContext servletContext = event.getServletContext();
        WebApplicationContext springContext = WebApplicationContextUtils.getRequiredWebApplicationContext(servletContext);

        // in a real application springContext is used to get access to some beans

        logger.info("===============================================================================");
        logger.info("== startup done.");
        logger.info("===============================================================================");

        servletContext.log("==> startup done <==");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
    }

}

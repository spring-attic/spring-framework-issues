package org.springframework.issues.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.FrameworkServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;
import org.springframework.web.util.HttpSessionMutexListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;


public class BootstrapSpringUsingInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger(BootstrapSpringUsingInitializer.class);


    @Override protected String[] getServletMappings() {
        return new String[]{ "/" };
    }

    @Override protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{ WebConfig.class };
    }

    @Override protected Class<?>[] getServletConfigClasses() {
        return null;
    }

    @Override protected FrameworkServlet createDispatcherServlet(WebApplicationContext servletAppContext) {
        DispatcherServlet dispatcherServlet = new DispatcherServlet(servletAppContext);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true); // we don't use a default handler but handle that exception in a controller advice (GlobalExceptionHandler)
        return dispatcherServlet;
    }

    @Override public void onStartup(ServletContext servletContext) throws ServletException {
        logger.info("===============================================================================");
        logger.info("==  starting up ...                                               ==");
        logger.info("===============================================================================");

        super.onStartup(servletContext);

        servletContext.addListener(new HttpSessionMutexListener());
        servletContext.addListener(new StartupListener());

        logger.info("... bootstrap code done.");
    }


}


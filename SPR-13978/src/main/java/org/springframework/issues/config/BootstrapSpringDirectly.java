package org.springframework.issues.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ConfigurableWebApplicationContext;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.HttpSessionMutexListener;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;


public class BootstrapSpringDirectly { //}  implements WebApplicationInitializer {

    static final String DISPATCHER_SERVLET_NAME = "SpringMVCDispatcher";
    static final Logger logger = LoggerFactory.getLogger(BootstrapSpringDirectly.class);

    //@Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        logger.info("===============================================================================");
        logger.info("==  starting up ...                                               ==");
        logger.info("===============================================================================");

        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();

        // XXX load everything here in order to have all our beans in one application context:
        rootContext.register(WebConfig.class); // DispatcherServlet creates another (empty) context which inherits from this application context

        servletContext.addListener(new ContextLoaderListener(rootContext));
        servletContext.addListener(new HttpSessionMutexListener());
        servletContext.addListener(new StartupListener());

        // register and map the dispatcher servlet:

        ConfigurableWebApplicationContext dispatcherContext = new AnnotationConfigWebApplicationContext(); // XXX do we need a child context?
        dispatcherContext.setParent(rootContext);
        DispatcherServlet dispatcherServlet = new DispatcherServlet(dispatcherContext);
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true); // we don't use a default handler but handle that exception in a controller advice (GlobalExceptionHandler)
        ServletRegistration.Dynamic registration = servletContext.addServlet(DISPATCHER_SERVLET_NAME, dispatcherServlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("/");
        registration.setAsyncSupported(true);


        logger.info("... bootstrap code done.");
    }


}


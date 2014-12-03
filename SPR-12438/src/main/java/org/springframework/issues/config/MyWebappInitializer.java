package org.springframework.issues.config;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.issues.web.AsyncServlet;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.ShallowEtagHeaderFilter;


public class MyWebappInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext applicationContext = new AnnotationConfigWebApplicationContext();
		applicationContext.register(WebConfig.class);

		ServletRegistration.Dynamic servletRegistration = servletContext.addServlet("async", new AsyncServlet(applicationContext));
		servletRegistration.setLoadOnStartup(1);
		servletRegistration.addMapping("/");
		servletRegistration.setAsyncSupported(true);

		FilterRegistration.Dynamic registration = servletContext.addFilter("etagFilter", new ShallowEtagHeaderFilter());
		registration.addMappingForServletNames(getDispatcherTypes(), false, "async");
		registration.setAsyncSupported(true);

		registration = servletContext.addFilter("encodingFilter", new CharacterEncodingFilter());
		registration.addMappingForServletNames(getDispatcherTypes(), false, "async");
		registration.setAsyncSupported(true);
	}

	private EnumSet<DispatcherType> getDispatcherTypes() {
		return EnumSet.of(DispatcherType.REQUEST, DispatcherType.ASYNC);
	}
}

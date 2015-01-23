package org.springframework.issues.config;

import javax.servlet.Filter;

import org.springframework.web.filter.CommonsRequestLoggingFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class WebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { WebConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	protected Filter[] getServletFilters() {
		final CommonsRequestLoggingFilter filter = new CommonsRequestLoggingFilter();
		filter.setIncludePayload(true);
		return new Filter[] {filter};
	}
}

package org.springframework.issues.config;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletContext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.resource.ResourceUrlProvider;
import org.springframework.web.servlet.resource.ResourceUrlProviderExposingInterceptor;

@Configuration
public class ResourceConfiguration {

	@Bean
	@Autowired
	public SimpleUrlHandlerMapping wuicResourceHandlerMapping(ApplicationContext applicationContext,
			ServletContext servletContext,
			ResourceUrlProvider resourceUrlProvider) {
		SimpleUrlHandlerMapping hm = new SimpleUrlHandlerMapping();
		hm.setUrlMap(createResourceHandlingUrlMap(applicationContext, servletContext));
		hm.setInterceptors(new HandlerInterceptor[] {
				new ResourceUrlProviderExposingInterceptor(resourceUrlProvider)});
		return hm;
	}

	private Map<String, ResourceHttpRequestHandler> createResourceHandlingUrlMap(ApplicationContext applicationContext,
			ServletContext servletContext) {
		Map<String, ResourceHttpRequestHandler> urlMap = new LinkedHashMap<String, ResourceHttpRequestHandler>();
		ResourceHttpRequestHandler resourceHandler = new ResourceHttpRequestHandler();
		resourceHandler.setServletContext(servletContext);
		resourceHandler.setApplicationContext(applicationContext);
		resourceHandler.setLocations(Collections.singletonList(applicationContext.getResource("classpath:/static/")));
		resourceHandler.setResourceResolvers(Collections.<ResourceResolver>singletonList(new PathResourceResolver()));
		urlMap.put("/static/**", resourceHandler);
		return urlMap;
	}

}

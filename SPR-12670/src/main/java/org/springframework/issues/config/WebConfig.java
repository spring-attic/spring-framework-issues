package org.springframework.issues.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@EnableWebMvc
@ComponentScan(basePackages = "org.springframework.issues")
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/").setViewName("home");
	}

	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/views/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {

		/*
		 *
		 * We want to serve up resources from this directory, using a wildcard.
		 * The way the PathResourceResolver.isResourceUnderLocation(resource,
		 * location) checks for a valid Resource treats wildcards as a specific
		 * file name and doesn't get a match.
		 *
		 * The fix is as easy as getting rid of the wildcards, but there are
		 * other times when wildcards would be nice to have in your resource
		 * handling paths.
		 *
		 * The bug/regression was added in 4.1.x (can't find exactly which
		 * release it was included in) as part of a refactoring of the
		 * PathResourceResolver (splitting it off from
		 * ResourceHttpRequestHandler):
		 *
		 * https://github.com/spring-projects/spring-framework/commit/6
		 * cb9a144db46af981fea4829e84044f05ce60a78
		 * #diff-a1b29b4519424378f9d0fc2f51465cdb
		 */

		// This doesn't work:
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/**");
		// This does work:
		// registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

}

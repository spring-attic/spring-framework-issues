package org.springframework.issues.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@ComponentScan(basePackages="org.springframework.issues")
@Configuration
public class WebConfig extends WebMvcConfigurationSupport {

	@Override
	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		FormHttpMessageConverter formConverter = new FormHttpMessageConverter();
		formConverter.addPartConverter(new BufferedImageHttpMessageConverter());
		formConverter.addPartConverter(new MappingJacksonHttpMessageConverter());
		converters.add(formConverter);
	}

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

}

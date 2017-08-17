package org.springframework.issues.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import com.fasterxml.jackson.databind.ObjectMapper;

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

	@Bean
	public MappingJackson2HttpMessageConverter jsonMessageConverter() {
		final MappingJackson2HttpMessageConverter mc = new MappingJackson2HttpMessageConverter();
		final ObjectMapper om = new ObjectMapper();
		mc.setObjectMapper(om);
		return mc;
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		System.out.println(String.format("Available Message Converters: %s", converters.size()));
		converters.add(jsonMessageConverter());
	}

}

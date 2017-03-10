package org.springframework.issues.config;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@ComponentScan(basePackages="org.springframework.issues")
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new StringHttpMessageConverter());
		//correct order
		//converters.add(httpMessageConverterConfig.mappingJackson2HttpMessageConverter());
		//converters.add(httpMessageConverterConfig.mappingJackson2XmlHttpMessageConverter());

		//NOT correct order
		converters.add(new MappingJackson2XmlHttpMessageConverter());
		converters.add(new MappingJackson2HttpMessageConverter());
	}

	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		configurer.favorPathExtension(true)
				.favorParameter(false)
				.ignoreAcceptHeader(false)
				.defaultContentType(new MediaType(MediaType.TEXT_PLAIN, Charset.forName("UTF-8")))
				.mediaType("html", MediaType.TEXT_HTML)
				.mediaType("xml", MediaType.APPLICATION_XML)
				.mediaType("json", MediaType.APPLICATION_JSON_UTF8);
	}
}

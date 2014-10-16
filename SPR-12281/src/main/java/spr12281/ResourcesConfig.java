package spr12281;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceChainRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.resource.VersionResourceResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration
@ComponentScan(basePackageClasses = { ResourcesConfig.class })
public class ResourcesConfig extends WebMvcConfigurationSupport
{
	@Bean
	public ViewResolver viewResolver ( )
	{
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class);
		viewResolver.setPrefix("/WEB-INF/");
		viewResolver.setSuffix(".jspx");
		return viewResolver;
	}

	@Override
	public HandlerMapping resourceHandlerMapping ( )
	{
		SimpleUrlHandlerMapping handlerMapping = (SimpleUrlHandlerMapping) super.resourceHandlerMapping();
		handlerMapping.setInterceptors(getInterceptors());
		return handlerMapping;
	}

	@Override
	public void configureDefaultServletHandling ( DefaultServletHandlerConfigurer configurer )
	{
		configurer.enable();
	}

	@Override
	public void addResourceHandlers ( ResourceHandlerRegistry registry )
	{
		ResourceHandlerRegistration resourceHandlerRegistration = registry.addResourceHandler("/**");
		resourceHandlerRegistration.addResourceLocations("/");
		ResourceChainRegistration resourceChain = resourceHandlerRegistration.resourceChain(false);
		VersionResourceResolver versionResolver = new VersionResourceResolver().addContentVersionStrategy("/**");
		resourceChain.addResolver(versionResolver);
	}
}
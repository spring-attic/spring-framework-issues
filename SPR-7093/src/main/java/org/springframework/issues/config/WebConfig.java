package org.springframework.issues.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

@EnableWebMvc
@ComponentScan(basePackages="org.springframework.issues")
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

	@Override
	public void configureViewResolution(ViewResolutionRegistry registry) {
		//registry.jsp();
		//registry.freemarker();
		//registry.velocity();
		registry.tiles().definition("/WEB-INF/tiles.xml");
		//registry.contentNegotiating(new MappingJackson2JsonView());
	}

}

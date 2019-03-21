/*
 * Copyright 2002-2014 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.issues;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.IDialect;
import org.thymeleaf.extras.tiles2.dialect.TilesDialect;
import org.thymeleaf.extras.tiles2.spring4.web.configurer.ThymeleafTilesConfigurer;
import org.thymeleaf.extras.tiles2.spring4.web.view.ThymeleafTilesView;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
public class Config extends WebMvcConfigurerAdapter {

	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		Set<TemplateResolver> templateResolvers = new java.util.HashSet<TemplateResolver>();
		templateResolvers.add(webTemplateResolver());
		templateEngine.setTemplateResolvers(templateResolvers);
		Set<IDialect> additionalDialects = new HashSet<IDialect>();
		additionalDialects.add(new TilesDialect());
		templateEngine.setAdditionalDialects(additionalDialects);
		return templateEngine;
	}

	@Bean
	public ServletContextTemplateResolver webTemplateResolver() {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix("WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode("HTML5");
		templateResolver.setCharacterEncoding("UTF-8");
		templateResolver.setOrder(2);
		return templateResolver;
	}

	@Bean
	public ThymeleafViewResolver viewResolver() {
		ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
		viewResolver.setViewClass(ThymeleafTilesView.class);
		viewResolver.setTemplateEngine(templateEngine());
		viewResolver.setCharacterEncoding("UTF-8");
		return viewResolver;
	}

	@Bean
	public ThymeleafTilesConfigurer tilesConfigurer() {
		ThymeleafTilesConfigurer tilesConfigurer = new ThymeleafTilesConfigurer();
		return tilesConfigurer;
	}

	@Bean
	public ContactController contactController() {
		return new ContactController();
	}
}

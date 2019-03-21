/*
 * Copyright 2006-2011 the original author or authors.
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

import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.ConfigurableWebApplicationContext;

/**
 * @author Dave Syer
 *
 */
public class Initializer implements ApplicationContextInitializer<ConfigurableWebApplicationContext> {

	@Override
	public void initialize(ConfigurableWebApplicationContext applicationContext) {

//		ServletContext servletContext = applicationContext.getServletContext();
//		WebApplicationContextUtils.initServletPropertySources(applicationContext.getEnvironment().getPropertySources(), servletContext, applicationContext.getServletConfig());
		
		String location = applicationContext.getEnvironment().getProperty("applicationProperties");
		if (location==null) {
			throw new IllegalStateException("Servlet context params not initialized");
		}
		
	}

}

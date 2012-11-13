/*
 * Copyright 2002-2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.web.servlet.view.tiles3;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Locale;
import java.util.Map;

import javax.servlet.ServletContext;

import org.apache.tiles.request.ApplicationResource;
import org.apache.tiles.request.locale.URLApplicationResource;
import org.apache.tiles.request.servlet.wildcard.WildcardServletApplicationContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.io.Resource;
import org.springframework.web.context.ServletContextAware;

/**
 * Delegates resource loading to Spring's {@link ApplicationContext}. Delegates
 * applicationScope and init-params to {@link WildcardServletApplicationContext}
 * .
 *
 * Expected to initialised as a spring bean.
 *
 * @author Nicolas Le Bas
 * @author mick semb wever
 */
public class SpringApplicationContext
		implements org.apache.tiles.request.ApplicationContext, ApplicationContextAware, ServletContextAware {

	private ApplicationContext applicationContext;
	private org.apache.tiles.request.ApplicationContext delegate;

	@Override
	public ServletContext getContext() {
		return (ServletContext) delegate.getContext();
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
	}

	@Override
	public void setServletContext(ServletContext servletContext) {
		delegate = createDelegate(servletContext);
	}

	@Override
	public Map<String, Object> getApplicationScope() {
		return delegate.getApplicationScope();
	}

	@Override
	public Map<String, String> getInitParams() {
		return delegate.getInitParams();
	}

	@Override
	public ApplicationResource getResource(String localePath) {
		try {
			URL url = applicationContext.getResource(localePath).getURL();
			if (url == null) {
				return null;
			} else {
				return new URLApplicationResource(url.toExternalForm(), url);
			}
		} catch (IOException e) {
			return null;
		}
	}

	@Override
	public ApplicationResource getResource(ApplicationResource base, Locale locale) {
		try {
			String path = base.getLocalePath(locale);
			URL url = applicationContext.getResource(path).getURL();
			if (url == null) {
				return null;
			} else {
				return new URLApplicationResource(url.toExternalForm(), url);
			}
		} catch (IOException e) {
			return null;
		}
	}

	@Override
	public Collection<ApplicationResource> getResources(String path) {
		ArrayList<ApplicationResource> resources = new ArrayList<ApplicationResource>();
		Resource[] foundResources;
		try {
			foundResources = applicationContext.getResources(path);
		} catch (IOException e) {
			return Collections.<ApplicationResource> emptyList();
		}
		for (Resource resource : foundResources) {
			try {
				URL url = resource.getURL();
				resources.add(new URLApplicationResource(url.toExternalForm(), url));
			} catch (IOException e) {
				continue;
			}
		}
		return resources;
	}

	/**
	 * Override if you want something other than delegation to
	 * WildcardServletApplicationContext.
	 */
	protected org.apache.tiles.request.ApplicationContext createDelegate(ServletContext servletContext) {
		return new WildcardServletApplicationContext(servletContext);
	}
}

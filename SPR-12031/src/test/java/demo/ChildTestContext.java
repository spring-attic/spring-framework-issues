/*
 * Copyright 2015 the original author or authors.
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

package demo;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.test.context.CacheAwareContextLoaderDelegate;
import org.springframework.test.context.MergedContextConfiguration;
import org.springframework.test.context.support.DefaultTestContext;

/**
 * @author Dave Syer
 *
 */
public class ChildTestContext extends DefaultTestContext {

	private static final Log logger = LogFactory.getLog(ChildMethodRule.class);
	private Method method;
	private ConfigurableApplicationContext closeable;

	public ChildTestContext(Class<?> testClass,
			MergedContextConfiguration mergedContextConfiguration,
			CacheAwareContextLoaderDelegate cacheAwareContextLoaderDelegate) {
		super(testClass, mergedContextConfiguration, cacheAwareContextLoaderDelegate);
	}

	@Override
	public ApplicationContext getApplicationContext() {
		ApplicationContext parent = super.getApplicationContext();
		ApplicationContext context = parent;
		if (this.method != null) {
			SpringApplicationBuilder builder = null;
			ChildSpringApplication annotation = AnnotatedElementUtils
					.getMergedAnnotation(this.method, ChildSpringApplication.class);
			if (annotation != null) {
				if (annotation.classes().length > 0) {
					builder = new SpringApplicationBuilder();
					for (Class<?> source : annotation.classes()) {
						builder.sources(source);
					}
				}
			}
			ChildTestProperties properties = AnnotatedElementUtils
					.getMergedAnnotation(this.method, ChildTestProperties.class);
			if (properties != null) {
				if (properties.value().length > 0) {
					if (builder == null) {
						builder = new SpringApplicationBuilder();
					}
					for (String source : properties.value()) {
						builder.properties(source);
					}
				}
			}
			if (builder != null) {
				this.closeable = builder
						.sources(PropertyPlaceholderAutoConfiguration.class)
						.bannerMode(Mode.OFF).web(false)
						.parent((ConfigurableApplicationContext) parent).run();
				context = this.closeable;
			}
		}
		return context;
	}

	public void close() {
		if (logger.isDebugEnabled()) {
			logger.debug("Closing child context.");
		}
		if (this.closeable != null && this.closeable.isActive()) {
			this.closeable.close();
		}
	}

	public void setTestMethod(Method method) {
		this.method = method;
	}

}

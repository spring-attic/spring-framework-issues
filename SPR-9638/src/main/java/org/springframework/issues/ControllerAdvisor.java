/*
 * Copyright 2002-2012 the original author or authors.
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

import java.lang.reflect.Method;

import org.springframework.aop.interceptor.SimpleTraceInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.StaticMethodMatcherPointcut;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Controller;

@SuppressWarnings("serial")
public class ControllerAdvisor extends DefaultPointcutAdvisor {

	public ControllerAdvisor() {
		super(new StaticMethodMatcherPointcut() {
			public boolean matches(Method method, Class<?> targetClass) {
				return (AnnotationUtils.findAnnotation(targetClass, Controller.class) != null);
			}
		}, new SimpleTraceInterceptor());
	}

}

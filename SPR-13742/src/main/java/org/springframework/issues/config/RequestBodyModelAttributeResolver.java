/*
 * Copyright 2002-2016 the original author or authors.
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
package org.springframework.issues.config;

import java.util.List;

import org.springframework.core.MethodParameter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.annotation.ModelAttributeMethodProcessor;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.RequestResponseBodyMethodProcessor;
import org.springframework.web.servlet.mvc.method.annotation.ServletModelAttributeMethodProcessor;


public class RequestBodyModelAttributeResolver implements HandlerMethodArgumentResolver {

	private final RequestResponseBodyMethodProcessor requestBodyResolver;

	private final ModelAttributeMethodProcessor modelAttributeResolver;


	public RequestBodyModelAttributeResolver(List<HttpMessageConverter<?>> converters) {
		this.requestBodyResolver = new RequestBodyResolver(converters);
		this.modelAttributeResolver = new ServletModelAttributeMethodProcessor(true);
	}


	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return parameter.hasParameterAnnotation(RequestBodyModelAttribute.class);
	}

	@Override
	public Object resolveArgument(MethodParameter param, ModelAndViewContainer container,
			NativeWebRequest request, WebDataBinderFactory factory) throws Exception {

		Object arg = this.requestBodyResolver.resolveArgument(param, container, request, factory);

		if (arg == null) {
			arg = this.modelAttributeResolver.resolveArgument(param, container, request, factory);
		}

		return arg;
	}


	private static class RequestBodyResolver extends RequestResponseBodyMethodProcessor {

		public RequestBodyResolver(List<HttpMessageConverter<?>> converters) {
			super(converters);
		}

		@Override
		protected boolean checkRequired(MethodParameter methodParam) {
			return false;
		}
	}

}

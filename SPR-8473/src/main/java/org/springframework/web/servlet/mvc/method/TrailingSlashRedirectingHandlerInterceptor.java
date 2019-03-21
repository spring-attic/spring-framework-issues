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
package org.springframework.web.servlet.mvc.method;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerMapping;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public class TrailingSlashRedirectingHandlerInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

		String pattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
		if (!pattern.endsWith("/")) {
			return true;
		}

		Collection<String> requestMappingPatterns = getRequestMappingPatterns(handler);
		if (CollectionUtils.isEmpty(requestMappingPatterns) || requestMappingPatterns.contains(pattern)) {
			return true;
		}

		if (requestMappingPatterns.contains(pattern.substring(0, pattern.length() - 1))) {
			ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromRequest(request);
			String path = builder.build().getPath();
			builder.replacePath(path.substring(0, path.length() - 1));
			String location = builder.build().toString();

			response.setStatus(HttpStatus.MOVED_PERMANENTLY.value());
			response.setHeader("Location", location);
			return false;
		}

		return true;
	}

	private Collection<String> getRequestMappingPatterns(Object handler) {

		// Just get patterns from the method @RequestMapping ...
		// In the real implementation AbstractHandlerMethodMapping.handleMatch
		// should to expose the mapping info to a request attribute

		if (handler instanceof HandlerMethod) {
			HandlerMethod handlerMethod = (HandlerMethod) handler;
			RequestMapping rm = handlerMethod.getMethodAnnotation(RequestMapping.class);
			return Arrays.asList(rm.value());
		}

		return Collections.emptyList();
	}

}

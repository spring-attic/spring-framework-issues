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

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.mvc.method.annotation.HttpEntityMethodProcessor;

public class ResponseEntityTests {

	@Test
	public void addCacheControl() throws Exception {

		HttpHeaders headers = new HttpHeaders();
		headers.setCacheControl("no-cache");
		ResponseEntity<Object> responseEntity = new ResponseEntity<Object>(headers, HttpStatus.OK);

		MockHttpServletRequest request = new MockHttpServletRequest();
		request.addHeader("Cache-Control", "no-cache");

		MockHttpServletResponse response = new MockHttpServletResponse();
		ServletWebRequest webRequest = new ServletWebRequest(request, response);

		MethodParameter returnType = new MethodParameter(this.getClass().getMethod("handle"), -1);

		List<HttpMessageConverter<?>> converters = Arrays.<HttpMessageConverter<?>>asList(new ByteArrayHttpMessageConverter());
		HttpEntityMethodProcessor processor = new HttpEntityMethodProcessor(converters);
		processor.handleReturnValue(responseEntity, returnType, new ModelAndViewContainer(), webRequest);

		assertEquals("no-cache", response.getHeader("Cache-Control"));
	}

	public ResponseEntity<Object> handle() {
		return null;
	}

}

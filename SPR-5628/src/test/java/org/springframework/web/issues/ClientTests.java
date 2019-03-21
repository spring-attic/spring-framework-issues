/*
 * Copyright 2002-2011 the original author or authors.
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

package org.springframework.web.issues;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Before running the tests, deploy this project and check it's running at:
 * http://localhost:8080/SPR-5628
 * 
 */
public class ClientTests {

	private static final String baseUrl = "http://localhost:8080/SPR-5628/test/";

	private RestTemplate template;
	
	private HttpEntity<?> requestEntity;

	@Before
	public void setup() {
		template = new RestTemplate(new HttpComponentsClientHttpRequestFactory());		
		MultiValueMap<String, String> params = new LinkedMultiValueMap<String, String>();
		params.add("param", "value");
		requestEntity = new HttpEntity<MultiValueMap<String, String>>(params, null);
	}
	
	@Test
	public void requestParamPut() {
		String url = baseUrl + "requestParam";
		ResponseEntity<String> response = template.exchange(url, HttpMethod.PUT, requestEntity, String.class);
		assertEquals("param=value", response.getBody());
	}
	
	@Test
	public void requestParamPost() {
		String url = baseUrl + "requestParam";
		ResponseEntity<String> response = template.exchange(url, HttpMethod.POST, requestEntity, String.class);
		assertEquals("param=value", response.getBody());
	}

	@Test
	public void requestBodyPut() {
		String url = baseUrl + "requestBody";
		ResponseEntity<String> response = template.exchange(url, HttpMethod.PUT, requestEntity, String.class);
		assertEquals("params={param=[value]}", response.getBody());
	}

	@Test
	public void requestBodyPost() {
		String url = baseUrl + "requestBody";
		ResponseEntity<String> response = template.exchange(url, HttpMethod.POST, requestEntity, String.class);
		assertEquals("params={param=[value]}", response.getBody());
	}

	@Test
	public void requestParamAndInputStreamPut() {
		String url = baseUrl + "requestParamAndInputStream";
		ResponseEntity<String> response = template.exchange(url, HttpMethod.PUT, requestEntity, String.class);
		assertEquals("param=null, content=[param=value]", response.getBody());
	}

	@Test
	public void requestParamAndInputStreamPost() {
		String url = baseUrl + "requestParamAndInputStream";
		ResponseEntity<String> response = template.exchange(url, HttpMethod.POST, requestEntity, String.class);
		assertEquals("param=value and content=[]", response.getBody());
	}

}

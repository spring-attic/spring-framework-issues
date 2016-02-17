/*
 * Copyright 2002-2016 the original author or authors.
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
package org.springframework.issues;

import java.util.Arrays;

import org.junit.Test;

import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

public class GreetingTests {

	@Test
	public void test() throws Exception {

		RestTemplate restTemplate = new RestTemplate();
		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

		String badUrl = "http://localhost:8080/greetings";
//		for (HttpMethod httpMethod : HttpMethod.values()) {
		for (HttpMethod httpMethod : Arrays.asList(HttpMethod.TRACE)) {
			try {
				restTemplate.execute(badUrl, httpMethod, null, null);
			} catch (Exception e) {
				System.err.println("Failed to " + httpMethod + " -- " + e.getMessage());
			}
		}

	}
}

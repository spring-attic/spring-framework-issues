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

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

public class Main {

	public static void main(String[] args) {

		List<HttpMessageConverter<?>> converters = new ArrayList<HttpMessageConverter<?>>(1);
		converters.add(new StringHttpMessageConverter());
		converters.add(new MappingJackson2HttpMessageConverter());

		RestTemplate restTemplate = new RestTemplate(converters);
//		restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());

		Person person = new Person();
		person.setId(1L);
		person.setName("Joe");

		ResponseEntity<String> response =
				restTemplate.exchange("http://localhost:8080/person/{id}",
						HttpMethod.DELETE,
						new HttpEntity<Person>(person),
						String.class,
						1);

		System.out.println(response);
		System.exit(0);
	}

}

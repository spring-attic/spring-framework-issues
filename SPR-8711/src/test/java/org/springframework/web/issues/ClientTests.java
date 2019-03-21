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

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Before running the tests, deploy this project and check it's running at:
 * http://localhost:8080/SPR-8711-1.0-SNAPSHOT
 * 
 */
public class ClientTests {

	private static final String baseUrl = "http://localhost:8080/SPR-8711/test/";

	private RestTemplate template;

	@Before
	public void setup() {
		template = new RestTemplate();
        final List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
        messageConverters.add(new MappingJacksonHttpMessageConverter());
        template.setMessageConverters(messageConverters);
	}

    @Test
    public void putFailsWith404() {
        TestObject object = new TestObject();

        object.setData("data");
        template.put(baseUrl + "update", object);
    }

    @Test
    public void getThatWorks() {
        TestObject response = template.getForObject(baseUrl + "get", TestObject.class);

        assertThat(response.getData(), is("data"));
    }

}

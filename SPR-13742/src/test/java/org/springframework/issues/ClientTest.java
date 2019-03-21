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
package org.springframework.issues;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.issues.config.TestEntity;
import org.springframework.issues.config.WebConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfig.class)
public class ClientTest {

	private static final String baseUrl = "http://localhost:8080/testEntity";

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	private TestEntity testEntity;


	@Before
	public void setUp() throws Exception {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
		this.testEntity = new TestEntity();
		this.testEntity.setName("Jack");
	}


	@Test
	public void postWithJson() throws Exception {

		MediaType contentType = MediaType.APPLICATION_JSON;
		String json = "{\"name\":\"" + this.testEntity.getName() + "\"}";

		this.mockMvc.perform(post(baseUrl).contentType(contentType).content(json))
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/views/testEntity.jsp"))
				.andExpect(model().attribute("testEntity", this.testEntity));
	}

	@Test
	public void postWithQueryParams() throws Exception {

		this.mockMvc.perform(post(baseUrl + "?name={name}", this.testEntity.getName()))
				.andExpect(status().isOk())
				.andExpect(forwardedUrl("/WEB-INF/views/testEntity.jsp"))
				.andExpect(model().attribute("testEntity", testEntity));
	}

}

/*
 * Copyright 2002-2015 the original author or authors.
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
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.springframework.http.MediaType;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@WebAppConfiguration
public class MvcTest {

	private MockMvc mockMvc;

	private PersonController controller;

	@Before
	public void setup() {
		controller = new PersonController();
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
	}

	@Test
	public void test() throws Exception {
		ResultActions result = mockMvc.perform(post("/person")
				.content("{\"n\": \"foo\"}")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.TEXT_PLAIN));

		result.andExpect(status().isOk()).andExpect(content().string("foo"));
	}

}

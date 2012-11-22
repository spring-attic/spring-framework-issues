package org.springframework.issues.test2;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

@WebAppConfiguration
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/servlet-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
public class Test2ControllerTests {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = webAppContextSetup(wac)
				.defaultRequest(get("/").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
				.build();
	}

	@Test
	public void testDto() throws Exception {

		String jsonContent = "{\"id\":1,\"value1\":\"foo\",\"value2\":\"bar\"}";

		this.mockMvc.perform(post("/testcontroller2/test2")
				.content(jsonContent))
				.andExpect(status().isOk())
				.andExpect(content().string(jsonContent));
	}

	@Test
	public void testDtoLists() throws Exception {

		String jsonContent =
				"[{\"id\":1,\"value1\":\"foo1\",\"value2\":\"bar1\"}," +
				"{\"id\":2,\"value1\":\"foo2\",\"value2\":\"bar2\"}," +
				"{\"id\":3,\"value1\":\"foo3\",\"value2\":\"bar3\"}]";

		this.mockMvc.perform(post("/testcontroller2/test2List")
				.content(jsonContent))
				.andExpect(status().isOk())
				.andExpect(content().string(jsonContent));
	}


	@Test
	public void testHttpEntity() throws Exception {

		String jsonContent = "{\"id\":1,\"value1\":\"foo\",\"value2\":\"bar\"}";

		this.mockMvc.perform(post("/testcontroller2/test2HttpEntity")
				.content(jsonContent))
				.andExpect(status().isOk())
				.andExpect(content().string(jsonContent));
	}

}

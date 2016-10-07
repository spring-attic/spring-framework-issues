package org.springframework.issues;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.issues.config.WebConfig;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy(@ContextConfiguration(classes = WebConfig.class))
public class ReproTests {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	@DirtiesContext // reset cache in CacheResourceResolver
	public void testFooTransformedResource() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/static/foo/style.css"))
				.andExpect(MockMvcResultMatchers.content()
						.string(Matchers.containsString("included-e6aa7205c3554eadf6e73f9e9f1b549c.css")));
	}

	@Test
	@DirtiesContext // reset cache in CacheResourceResolver
	public void testBarTransformedResource() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/static/bar/style.css"))
				.andExpect(MockMvcResultMatchers.content()
						.string(Matchers.containsString("included-d6b6a7e96c7197e04466a98ca379b3ab.css")));
	}

	@Test
	@DirtiesContext // reset cache in CacheResourceResolver
	public void testCachingOfTransformedResources() throws Exception {
		// resource "foo/included.css" is cached with path "included.css"
		this.mockMvc.perform(MockMvcRequestBuilders.get("/static/foo/style.css"))
				.andExpect(MockMvcResultMatchers.content()
						.string(Matchers.containsString("included-e6aa7205c3554eadf6e73f9e9f1b549c.css")));

		// resolving "/bar/included.css", should get the right one from cache
		this.mockMvc.perform(MockMvcRequestBuilders.get("/static/bar/style.css"))
				.andExpect(MockMvcResultMatchers.content()
						.string(Matchers.containsString("included-d6b6a7e96c7197e04466a98ca379b3ab.css")));
	}
}

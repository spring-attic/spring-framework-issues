package org.springframework.issues;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.issues.config.WebConfig;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.Is.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfig.class)
public class ReproTests {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	@Before
	public void setUpMockMvc() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	@Test
	public void specifyRequestParameters() throws Exception {
		this.mockMvc.perform(
				get("/search")
						.param("words", "aaa")
						.param("words", "bbb")
		)
				.andExpect(
						status().isOk()
				)
				.andExpect(
						model().attribute("words", is("[aaa, bbb]"))
				);
	}

	@Test
	public void doesNotSpecifyRequestParameters() throws Exception {
		this.mockMvc.perform(
				get("/search")
		)
				.andExpect(
						status().isOk()
				)
				.andExpect(
						model().attribute("words", is("[word1, word2, word3]"))
				);
	}

	@Controller
	public static class OptionalController {
		@RequestMapping("search")
		public void search(@RequestParam(defaultValue = "word1,word2,word3") Optional<List<String>> words, Model model) {
			model.addAttribute("words", words.get().toString());
		}
	}

}

package jira.working;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Spr13580Application.class)
@WebAppConfiguration
public class Spr13580ApplicationTests {
	@Autowired
	WebApplicationContext wac;

	MockMvc mvc;

	@Before
	public void setup() {
		mvc = MockMvcBuilders.webAppContextSetup(wac)
				.build();
	}

	@Test
	public void invalid() throws Exception {
		mvc.perform(post("/test/doPost").param("valid", "false"))
			.andExpect(model().hasErrors());
	}

	@Test
	public void valid() throws Exception {
		mvc.perform(post("/test/doPost").param("valid", "true"))
			.andExpect(model().hasNoErrors());
	}
}

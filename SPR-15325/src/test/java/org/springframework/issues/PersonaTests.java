package org.springframework.issues;

import org.junit.Test;

import org.springframework.http.MediaType;
import org.springframework.issues.config.WebConfig;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

public class PersonaTests {


	@Test
	public void test() throws Exception {

		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setServletContext(new MockServletContext());
		context.register(WebConfig.class);
		context.refresh();

		MockMvcBuilders.webAppContextSetup(context).build()
				.perform(get("/personas").accept(MediaType.APPLICATION_JSON_UTF8))
				.andDo(print());

	}
}

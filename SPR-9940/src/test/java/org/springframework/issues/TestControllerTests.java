package org.springframework.issues;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasProperty;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;

public class TestControllerTests {

	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = standaloneSetup(new TestController()).build();
	}

	@Test
	public void testMav() throws Exception {

		MyBody myBody = new MyBody();
		myBody.setName("Joe");

		this.mockMvc.perform(get("/mav"))
				.andExpect(content().string("ss"))
				.andExpect(model().attribute("myBody", hasProperty("name", equalTo("Jeronimo"))));
	}

	@Test
	public void testMatcherAssert() throws Exception {
		MyBody actual = new MyBody();
		actual.setName("Jon");
		MatcherAssert.assertThat(actual, hasProperty("name", equalTo("Jeronimo")));
	}

	@Test
	public void testMatcher() throws Exception {
		Matcher<String> matcher = hasProperty("name");
//		matcher.describeMismatch("Foo", new Description.NullDescription());
	}
//
//	public static class MyMatcher extends BaseMatcher<String> {
//		@Override
//		public boolean matches(Object item) { return false; }
//		@Override
//		public void describeMismatch(Object item, Description description) { super.describeMismatch(item, description); }
//		@Override
//		public void describeTo(Description description) { }
//	}

}

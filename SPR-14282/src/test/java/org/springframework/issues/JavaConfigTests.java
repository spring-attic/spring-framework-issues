package org.springframework.issues;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods
 * within need not pass with the green bar! Rather they should fail in such a
 * way that demonstrates the reported issue.
 */
public class JavaConfigTests {

	@Test
	public void repro() {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext()) {
			ctx.register(Config.class);
			ctx.refresh();

			Foo foo = ctx.getBean(Foo.class);

			assertThat(foo.bar, nullValue());
		}
	}

	@Configuration
	static class Config {

		@Bean
		public Foo foo() {
			return new Foo();
		}

		@Bean
		public Bar bar() {
			return new Bar();
		}

	}
}

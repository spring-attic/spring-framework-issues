package org.springframework.issues;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.mock.web.MockServletContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within need not pass with the green bar!
 * Rather they should fail in such a way that demonstrates the reported issue.
 */
public class ReproTests {

	@Test
	public void repro() {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		ctx.setServletContext(new MockServletContext());
		ctx.register(Config.class);
		ctx.refresh();

		Foo foo = ctx.getBean(Foo.class);
		assertNotNull(foo);
		
		ctx.close();
	}

	@Configuration
	@EnableWebMvc
	protected static class Config {

		@Bean
		@Lazy
		@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
		public Foo foo() {
			return new Foo();
		}

	}

	@RestController
	protected static class Foo {
		
		@RequestMapping("/")
		public String home() {
			return "Hello";
		}

	}

}

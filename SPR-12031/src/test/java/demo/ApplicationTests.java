package demo;

import static org.junit.Assert.assertEquals;

import org.junit.ClassRule;
import org.junit.Rule;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.BootstrapWith;
import org.springframework.test.context.junit4.rules.SpringClassRule;

import demo.ApplicationTests.Application;

@SpringApplicationConfiguration(classes = Application.class)
@BootstrapWith(ChildContextBootstrapper.class)
@IntegrationTest("logging.level.org.springframework.web=DEBUG")
public class ApplicationTests {

	@ClassRule
	public static final SpringClassRule springClass = new SpringClassRule();

	@Rule
	public final ChildMethodRule springMethod = new ChildMethodRule();

	@Autowired
	private String foo;

	@Test
	public void contextLoads() {
		assertEquals("foo", this.foo);
	}

	@Test
	@ChildSpringApplication(Child.class)
	public void contextLoadsChild() {
		assertEquals("bar", this.foo);
	}

	@Test
	@ChildSpringApplication(ChildWithValue.class)
	@ChildTestProperties("foo=spam")
	public void contextLoadsChildWithProperties() {
		assertEquals("spam", this.foo);
	}

	@Configuration
	public static class Application {
		@Bean
		public String foo() {
			return "foo";
		}
	}

	@Configuration
	public static class Child {
		@Bean
		public String foo() {
			return "bar";
		}
	}

	@Configuration
	public static class ChildWithValue {
		@Value("${foo}")
		private String foo;

		@Bean
		public String foo() {
			return this.foo;
		}
	}

}

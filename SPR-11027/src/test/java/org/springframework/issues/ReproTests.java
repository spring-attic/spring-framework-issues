package org.springframework.issues;

import static java.lang.Boolean.TRUE;
import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within need not pass with the green bar!
 * Rather they should fail in such a way that demonstrates the reported issue.
 */
public class ReproTests {

	@Test
	public void shouldAutowire() {
		GenericXmlApplicationContext ctx = getContext();

		Foo foo = (Foo) ctx.getBean("justFoo");
		assertThat(foo.getBars().size(), CoreMatchers.equalTo(1));
	}

	@Test
	public void shouldOverrideAutowiredWithExplicitXml() {
		GenericXmlApplicationContext ctx = getContext();

		Foo foo = (Foo) ctx.getBean("foo");
		assertThat(foo.getBars().isEmpty(), CoreMatchers.equalTo(TRUE));
	}

	@Test
	public void shouldOverrideAutowiredWithExplicitXmlEvenAfterAutowiredUsed() {
		GenericXmlApplicationContext ctx = getContext();

		ctx.getBean("justFoo");

		Foo foo = (Foo) ctx.getBean("foo");
		assertThat(foo.getBars().isEmpty(), CoreMatchers.equalTo(TRUE));
	}

	@Test
	public void shouldAutowireEvenAfterOtherMoreExplicitBeanIsInstantiated() {
		GenericXmlApplicationContext ctx = getContext();

		ctx.getBean("foo");

		Foo foo = (Foo) ctx.getBean("justFoo");
		assertThat(foo.getBars().size(), CoreMatchers.equalTo(1));
	}

	private GenericXmlApplicationContext getContext() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:org/springframework/issues/ReproTests-context.xml");
		ctx.refresh();
		return ctx;
	}
}

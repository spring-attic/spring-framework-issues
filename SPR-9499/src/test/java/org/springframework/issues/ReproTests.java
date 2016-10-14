package org.springframework.issues;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ReproTests {

	@Test // FAIL! (understandable maybe)
	public void foo() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:org/springframework/issues/Foo-context.xml");
		ctx.refresh();

		Foo foo = ctx.getBean(Foo.class);

		assertThat(foo.getParameters().getFirst("foo"), equalTo("bar"));
	}

	@Test // FAIL! (and arguably should pass)
	public void fooWithConversion() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:org/springframework/issues/Foo-ConversionService-context.xml");
		ctx.refresh();

		Foo foo = ctx.getBean(Foo.class);

		assertThat(foo.getParameters().getFirst("foo"), equalTo("bar"));
	}

	@Test // Success (and so it should be)
	public void bar() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:org/springframework/issues/Bar-context.xml");
		ctx.refresh();

		Bar foo = ctx.getBean(Bar.class);

		assertThat(foo.getParameters().getFirst("foo"), equalTo("bar"));
	}

	@Test // FAIL! This is the closest to the original SPR-9499
	public void barWithConversion() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:org/springframework/issues/Bar-ConversionService-context.xml");
		ctx.refresh();

		Bar foo = ctx.getBean(Bar.class);

		assertThat(foo.getParameters().getFirst("foo"), equalTo("bar"));
	}
}

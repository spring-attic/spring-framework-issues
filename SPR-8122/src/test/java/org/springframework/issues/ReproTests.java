package org.springframework.issues;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ReproTests {

	@Test
	public void repro() {
		System.out.println("here");
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		System.out.println("there");
		ctx.load("classpath:org/springframework/issues/ReproTests-context.xml");
		ctx.refresh();

		Foo foo = ctx.getBean(Foo.class);
		Bar bar = ctx.getBean(Bar.class);

		assertThat(foo.getBar(), sameInstance(bar));
		ctx.close();
	}

}


package org.springframework.issues;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.junit.Assert.*;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within need
 * not pass with the green bar! Rather they should fail in such a way that demonstrates
 * the reported issue.
 */
public class ReproTests {

	@Test
	public void works() throws Exception {
		repro("ReproTests-context.xml");
	}

	@Test
	public void fails() throws Exception {
		repro("ReproTests-context-fails.xml");
	}

	private void repro(String xml) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setIgnoreUnresolvableNestedPlaceholders(true);
		ctx.load("classpath:org/springframework/issues/" + xml);
		ctx.refresh();

		Foo foo = ctx.getBean(Foo.class);
		assertEquals(foo.getAbc(), "${none}");
		assertEquals(foo.getAbc2(), "test");
		ctx.close();
	}

}

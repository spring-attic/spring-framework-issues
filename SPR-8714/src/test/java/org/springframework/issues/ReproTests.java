package org.springframework.issues;

import static org.junit.Assert.*;

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
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:org/springframework/issues/ReproTests-context.xml");
		ctx.refresh();

		TestMap testMap = ctx.getBean(TestMap.class);
		TestMapConsumer testMapConsumer = ctx.getBean(TestMapConsumer.class);

		assertEquals(0, testMap.size());
		assertEquals(0, testMapConsumer.getTestMap().size());
	}

}

package org.springframework.issues;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ReproTests {

	@Test
	public void repro() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		AnnotationConfigApplicationContext dispatcherCtx = new AnnotationConfigApplicationContext();
		dispatcherCtx.setParent(ctx);
		dispatcherCtx.register(DispatcherConfig.class);
		dispatcherCtx.refresh();

		assertTrue(ctx.containsLocalBean("fooBean"));
		assertFalse(ctx.containsLocalBean("fooController"));

		assertFalse(dispatcherCtx.containsLocalBean("fooBean"));
		assertTrue(dispatcherCtx.containsLocalBean("fooController"));
	}

}

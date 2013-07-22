package org.springframework.issues;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.util.StopWatch;

import static org.junit.Assert.*;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ReproTests {

	@Test
	public void repro() {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ApplicationConfig.class);
		StopWatch stopWatch = new StopWatch();
		stopWatch.start();
		context.refresh();
		assertNotNull(context.getBean(Foo.class));
		stopWatch.stop();
		System.out.println(stopWatch.prettyPrint());
		context.close();
	}

}

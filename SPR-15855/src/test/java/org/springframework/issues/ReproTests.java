package org.springframework.issues;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
@Configuration
@ComponentScan
public class ReproTests {

	@Test
	public void repro() {
		ApplicationContext context = new AnnotationConfigApplicationContext(ReproTests.class);
		Test printer = context.getBean(Test.class);
	}

}


package org.springframework.issues;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.issues.bean.CouldBeAdvised;
import org.springframework.issues.config.ApplicationConfig;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ReproTests {

	@Test
	public void should_not_advise_the_bean_based_on_its_actual_type() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);

        CouldBeAdvised advisedOrNot = ctx.getBean(CouldBeAdvised.class);

        advisedOrNot.doNothing();
	}

}

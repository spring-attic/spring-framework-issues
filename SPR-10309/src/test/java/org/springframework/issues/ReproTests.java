
package org.springframework.issues;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.fail;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within need
 * not pass with the green bar! Rather they should fail in such a way that demonstrates
 * the reported issue.
 */
public class ReproTests {

	@Test
	public void repro() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(
				ReproConfig.class);

		Foo foo = ctx.getBean(Foo.class);

		try {
			foo.bar();
			fail();
		}
		catch (ValidationException e) {
			// just to show that the aspect works
		}

		try {
			foo.bar(null);
			fail();
		}
		catch (ValidationException e) {
			// MethodValidationInterceptor always gets the highest advisor spot and will
			// not budge
		}
	}

}

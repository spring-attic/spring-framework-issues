
package org.springframework.issues;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within need
 * not pass with the green bar! Rather they should fail in such a way that demonstrates
 * the reported issue.
 */
public class ReproTests {

	@Test
	public void repro() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:org/springframework/issues/ReproTests-context.xml");
		ctx.refresh();

		Foo foo = ctx.getBean(Foo.class);

		assertThat(foo.isMogoSlaveOk(), equalTo(true));
	}

}

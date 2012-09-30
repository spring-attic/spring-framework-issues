package org.springframework.issues;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Calendar;
import java.util.TimeZone;

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

		Bar bar = ctx.getBean(Bar.class);

		Calendar c = Calendar.getInstance();
		c.clear();
		c.setTimeZone(TimeZone.getTimeZone("UTC"));
		c.set(2009, 5, 1);
		c.set(Calendar.HOUR, 14);
		c.set(Calendar.MINUTE, 23);
		c.set(Calendar.SECOND, 05);
		c.set(Calendar.MILLISECOND, 03);
		assertThat(bar.getDate(), is(c.getTime()));
	}

}

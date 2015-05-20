package org.springframework.issues;

import org.junit.Assert;
import org.junit.Test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ReproTests {

	@Test
	public void repro() {
		ClassPathXmlApplicationContext ctx =
				new ClassPathXmlApplicationContext("classpath:org/springframework/issues/ReproTests-context.xml");
		ctx.refresh();

		String a = "1";
		long key = 1;


		Foo foo = (Foo) ctx.getBean("myFoo");

		// keys are String
		Assert.assertFalse(foo.getObjectMap().containsKey(1));
		Assert.assertFalse(foo.getObjectMap().containsKey(Long.valueOf(1L)));
		Assert.assertFalse(foo.getObjectMap().containsKey(key));
		Assert.assertTrue(foo.getObjectMap().containsKey(a));

		System.out.println(foo.getObjectMap());

		Foo fooFixed = (Foo) ctx.getBean("myFooFixed");

		// keys are Long, as expected
		Assert.assertFalse(fooFixed.getObjectMap().containsKey(1));
		Assert.assertTrue(fooFixed.getObjectMap().containsKey(Long.valueOf(1L)));
		Assert.assertTrue(fooFixed.getObjectMap().containsKey(key));
		Assert.assertFalse(fooFixed.getObjectMap().containsKey(a));

		System.out.println(foo.getObjectMap());
	}

}

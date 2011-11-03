package org.springframework.issues;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.ClassUtils;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ReproTests {

    @Test
    public void testPlainObjectSucess() {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:org/springframework/issues/ReproTests-context.xml");
        ctx.refresh();

        Baz bean = ctx.getBean(Baz.class);

        Assert.assertTrue( bean.getClass() == Baz.class );
        Assert.assertEquals(1, bean.getValueCounter());

        MyPropertyPlaceholderConfigurer ppc = ctx.getBean( MyPropertyPlaceholderConfigurer.class );
        ppc.reload();

        Assert.assertEquals(2, bean.getValueCounter());

    }

	@Test
	public void testJdkProxyObjectFail() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:org/springframework/issues/ReproTests-context.xml");
		ctx.refresh();

		Bar bean = ctx.getBean(Bar.class);

		Assert.assertFalse( ClassUtils.isCglibProxy( bean ) );
		Assert.assertFalse( bean.getClass() == BarImpl.class );
		Assert.assertEquals(1, bean.getValueCounter());

		MyPropertyPlaceholderConfigurer ppc = ctx.getBean( MyPropertyPlaceholderConfigurer.class );
		ppc.reload();

		Assert.assertEquals(2, bean.getValueCounter());

	}

	@Test
    public void testCglibProxyObjectFail() {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:org/springframework/issues/ReproTests-context.xml");
        ctx.refresh();

        Foo bean = ctx.getBean(Foo.class);

        Assert.assertTrue( ClassUtils.isCglibProxy( bean ) );
        Assert.assertEquals(1, bean.getValueCounter());

        MyPropertyPlaceholderConfigurer ppc = ctx.getBean( MyPropertyPlaceholderConfigurer.class );
        ppc.reload();

        Assert.assertEquals(2, bean.getValueCounter());

    }

}

package org.springframework.issues;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ReproTests {

	@Test
	public void xml() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:module.xml");
		ctx.refresh();
		Foo foo = ctx.getBean(Foo.class);
		assertNotNull(foo);
		ctx.close();
	}

    @Test
    public void annotation() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(Bar.class);
        ctx.refresh();
        Foo foo = ctx.getBean(Foo.class);
        assertNotNull(foo);
        ctx.close();
    }

    @Test
    public void importResource() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(Starter.class);
        ctx.refresh();
        Foo foo = ctx.getBean(Foo.class);
        assertNotNull(foo);
        ctx.close();
    }

    @Configuration
    @ImportResource("module.xml")
    protected static class Starter {
    }
}

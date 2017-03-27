package org.springframework.issues;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Unit test that reproduces <a href="https://jira.spring.io/browse/SPR-15384">SPR-15384</a>
 */
public class ReproTests {


    /**
     * if member classes are ordered, an instance of class {@link Foo} should be added with name "test".
     * If members are ordered alphabetically, it will be of class {@link Bar}
     */
    @Test
    public void repro() {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(Config.class);
        ctx.refresh();

        Object test = ctx.getBean(Config.BEAN_NAME);

        assertThat(test, is(instanceOf(Foo.class)));
        
        ctx.close();
    }

}

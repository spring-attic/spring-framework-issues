package org.springframework.issues;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ReproTests {

    @Test
    public void executeWithNotNull() {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("org/springframework/issues/ReproTests-context.xml");
        ctx.registerShutdownHook();

        SampleService sampleService = ctx.getBean("sampleService", SampleService.class);
        sampleService.execute(new SampleDto()); // -> OK
        sampleService.execute(new SampleInputBean()); // -> OK

    }

    @Test
    public void executeWithNull() {
        ConfigurableApplicationContext ctx = new ClassPathXmlApplicationContext("org/springframework/issues/ReproTests-context.xml");
        ctx.registerShutdownHook();

        SampleService sampleService = ctx.getBean("sampleService", SampleService.class);
        sampleService.execute((SampleDto)null); // -> OK
        sampleService.execute((SampleInputBean) null); // -> NPE.

    }

}

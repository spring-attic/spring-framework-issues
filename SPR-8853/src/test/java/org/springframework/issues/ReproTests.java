package org.springframework.issues;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ReproTests
{

    @Test // this fails
    public void testAppConfigWithComponentScan()
    {
        // use the java config class with @ComponentScan annotation
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigWithComponentScan.class);
        CustomerDAO dao = ctx.getBean(CustomerDAO.class);
        assertNotNull(dao);
    }

    @Test // this works
    public void testAppConfigWithoutComponentScan()
    {
        // use the java config with componentScan taken from external resource
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfigWithoutComponentScan.class);
        CustomerDAO dao = ctx.getBean(CustomerDAO.class);
        assertNotNull(dao);
    }

}

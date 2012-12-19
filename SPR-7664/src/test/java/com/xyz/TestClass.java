package com.xyz;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @author borisb
 */
@ContextConfiguration(locations = {"/applicationContext.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class TestClass {

    private static final Logger log = Logger.getLogger(TestClass.class);

    @Resource(name = "demoService")
    private DemoService demoService;

    @Test
    public void testAspect() {
        log.info("@Secured annotated method");
        try {
            demoService.secureMethod("firstName", "lastName");
            Assert.fail("exception not thrown!");
        }
        catch (Exception e) {
            if (e.getCause().getMessage().equals("aspect invoked")) {
                log.info("@Secured annotated method invoked");
            } else {
                Assert.fail("wrong exception thrown!");
            }
        }

        log.info("no annotated method");
        try {
            demoService.unsecureMethod("firstName", "lastName");
        }
        catch (Exception e) {
            Assert.fail("exception thrown!");
        }
    }

}

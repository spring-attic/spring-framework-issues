package test;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;

import java.beans.Introspector;


/**
 * Created by IntelliJ IDEA.
 * User: nardonep
 * Date: 27/10/11
 * Time: 15:13
 * To change this template use File | Settings | File Templates.
 */

@ContextConfiguration
public class Test extends AbstractTestNGSpringContextTests {

    @org.testng.annotations.Test
    public void testName() throws Exception {
        applicationContext.getBean("test");
        applicationContext.getBean("test");
        ObjectFactory of = applicationContext.getBean("bookfactory", org.springframework.beans.factory.ObjectFactory.class);
        of.getObject();
        of = applicationContext.getBean("libfactory", org.springframework.beans.factory.ObjectFactory.class);
        of.getObject();


        applicationContext.getBean("mybook");



    }
}

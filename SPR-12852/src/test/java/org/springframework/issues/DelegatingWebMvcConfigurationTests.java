package org.springframework.issues;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration
public class DelegatingWebMvcConfigurationTests {

    @Autowired
    ApplicationContext context;

    @Configuration
    @EnableWebMvc
    static class Config {
        /**
         * Note: This configuration works as expected.  As you will
         * see in other unit tests, the callback behavior changes
         * (not all methods are called) when additional autowired
         * dependencies are added.
         */
        @Bean
        TestWebMvcConfigurer testWebMvcConfigurer() {
            return new TestWebMvcConfigurer();
        }
    }

    @Test
    public void testThatAllMethodsOnTestWebMvcConfigurerGotCalled() {
        TestWebMvcConfigurer testWebMvcConfigurer = context.getBean(TestWebMvcConfigurer.class);
        Assert.assertNotNull(testWebMvcConfigurer);
        Assert.assertEquals(testWebMvcConfigurer.getCallbackMethodsThatWereNotCalled(), TestWebMvcConfigurer.CALLBACK_METHOD_COUNT, testWebMvcConfigurer.getCounterValue());
    }

}


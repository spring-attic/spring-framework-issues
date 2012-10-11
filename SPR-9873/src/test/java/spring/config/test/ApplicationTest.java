package spring.config.test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.config.MyBean;
import spring.config.aop.CatchAspect;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.Assert.assertTrue;

/**
 * @author jbaruch
 * @since 10/10/12
 */
public class ApplicationTest {

    @Test
    public void testConfiguration() {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("spring.config");
        MyBean myBean = applicationContext.getBean(MyBean.class);
        assertNotNull(myBean);
        myBean.methodToCall();
        assertTrue(myBean.isMethodCalled());
        CatchAspect aspect = applicationContext.getBean(CatchAspect.class);
        assertTrue(aspect.isBeanCought());
        assertTrue(aspect.isConfigurationCought());
    }
}

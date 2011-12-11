package org.springframework.bugs.autowiring;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/org/springframework/bugs/autowiring/spring.xml")
public class AutowiringTest {
    
    @Test
    public void triggerContextInstantiation() throws Exception {
        
    }
}

package org.openehealth.tutorial;

import org.apache.camel.ProducerTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({DependencyInjectionTestExecutionListener.class})
@ContextConfiguration(locations = {"/dynamic-ref.xml"})
public class DynamicRefTest {

    @Autowired
    private ProducerTemplate producerTemplate;

    @Test
    public void dynamicRefTest() throws Exception {
       Common.routeTest(producerTemplate);
    }

}

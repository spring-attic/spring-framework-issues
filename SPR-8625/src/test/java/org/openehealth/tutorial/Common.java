package org.openehealth.tutorial;

import org.apache.camel.ProducerTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openehealth.ipf.modules.hl7dsl.MessageAdapters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import static org.junit.Assert.assertEquals;


public class Common {

    public static void routeTest(ProducerTemplate producerTemplate) throws Exception {
        Resource input = new ClassPathResource("/msg-01.hl7");
        producerTemplate.requestBody("direct:input", input.getInputStream());
        Resource result = new FileSystemResource("target/output/HZL.hl7");
        assertEquals(
                MessageAdapters.load("msg-01.hl7.expected").toString(),
                MessageAdapters.make(result.getInputStream()).toString());
    }

}

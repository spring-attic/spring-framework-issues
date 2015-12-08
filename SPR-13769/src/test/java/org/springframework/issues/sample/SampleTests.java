package org.springframework.issues.sample;

import org.apache.activemq.artemis.api.jms.JMSFactoryType;
import org.apache.activemq.artemis.core.config.impl.SecurityConfiguration;
import org.apache.activemq.artemis.jms.client.ActiveMQConnectionFactory;
import org.apache.activemq.artemis.jms.server.JMSServerManager;
import org.apache.activemq.artemis.jms.server.embedded.EmbeddedJMS;
import org.apache.activemq.artemis.spi.core.security.ActiveMQSecurityManagerImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.SimpleMessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SampleTests.Config.class})
public class SampleTests {

    @Autowired
    Producer producer;

	// Start the ActiveMQ Artemis
	@BeforeClass
	public static void execBeforeClass() throws Exception {

		EmbeddedJMS jmsServer = new EmbeddedJMS();
		SecurityConfiguration securityConfig = new SecurityConfiguration();
		securityConfig.addUser("guest", "guest");
		securityConfig.addRole("guest", "guest");
		securityConfig.setDefaultUser("guest");
		jmsServer.setSecurityManager(new ActiveMQSecurityManagerImpl(securityConfig));
		jmsServer.start();

		JMSServerManager jmsServerManager = jmsServer.getJMSServerManager();
		List<String> connectors = new ArrayList<String>();
		connectors.add("in-vm");
		jmsServerManager.createConnectionFactory("ConnectionFactory", false,JMSFactoryType.CF, connectors, "ConnectionFactory");
		jmsServerManager.createQueue(false, "TestQueue", null, false, "queue/TestQueue");
		jmsServerManager.createQueue(false, "TestQueue2", null, false, "queue/TestQueue2");
		jmsServerManager.createQueue(false, "ReplyTestQueue", null, false, "queue/ReplyTestQueue");
		jmsServerManager.createQueue(false, "ReplyTestQueue2", null, false, "queue/ReplyTestQueue2");

		System.out.println("Started Embedded JMS Server");
	}
    
    // NG(Error) pattern
    @Test
    public void sendBytes() throws JMSException {

    	// input data
        byte[] bytes = "Test Data!".getBytes();
    	
        byte[] retBytes = producer.send("TestQueue", bytes );

        System.out.println(new String(retBytes));

        Assert.assertEquals(new String(bytes), new String(retBytes));
    }


    // OK pattern
    @Test
    public void sendText() throws JMSException {

    	// input data
    	String text = "Test Data2!";

        String retText = producer.send2("TestQueue2", text);

        System.out.println(retText);

        Assert.assertEquals(text, retText);

    }


    @Configuration
    @ComponentScan(value = "org.springframework.issues")
    static class Config {

        @Bean
        ActiveMQConnectionFactory connectionFactory() {
            return new ActiveMQConnectionFactory("vm://0");
        }

        @Bean
        SimpleMessageConverter messageConverter() {
            SimpleMessageConverter simpleMessageConverter = new SimpleMessageConverter();
            return simpleMessageConverter;
        }

        @Configuration
        static class ClientConfig {

            @Bean
            JmsTemplate jmsTemplate(
                    ConnectionFactory connectionFactory,
                    MessageConverter messageConverter) {
                JmsTemplate jmsTemplate = new JmsTemplate();
                jmsTemplate.setConnectionFactory(connectionFactory);
                jmsTemplate.setMessageConverter(messageConverter);
                jmsTemplate.setReceiveTimeout(TimeUnit.SECONDS.toMillis(3));
                return jmsTemplate;
            }
        }

        @Configuration
        @EnableJms
        static class ServiceConfig {

            @Bean
            DefaultJmsListenerContainerFactory jmsListenerContainerFactory(
                    ConnectionFactory connectionFactory,
                    MessageConverter messageConverter) {
                DefaultJmsListenerContainerFactory factory =
                        new DefaultJmsListenerContainerFactory();
                factory.setConnectionFactory(connectionFactory);
                factory.setMessageConverter(messageConverter);
                return factory;
            }
        }
    }
}
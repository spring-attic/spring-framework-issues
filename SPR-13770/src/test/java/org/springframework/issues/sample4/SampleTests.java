package org.springframework.issues.sample4;

import static org.junit.Assert.*;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;

import java.util.UUID;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SampleTests.Config.class)
public class SampleTests {

    @Autowired
    Producer producer;
    
    
    @Test
    public void jmsPriority_to_5() throws JMSException {

        String randomId = UUID.randomUUID().toString();
        Todo todo = new Todo();
        todo.setTitle("Hello JMS");
        todo.setDescription("Test message sending using JMS.");
        
        Message<Todo> message = producer.send("TestQueue1", todo, randomId);

        System.out.println(message);
        
        Assert.assertNotNull(message);

        Assert.assertEquals(randomId, message.getHeaders().get("randomId"));


    }
    
   

    @Configuration
    @ComponentScan(value = "org.springframework.issues")
    static class Config {

        @Bean
        BrokerService brokerService() throws Exception {
            BrokerService brokerService = new BrokerService();
            brokerService.setPersistent(false);
            return brokerService;
        }

        @Bean
        ActiveMQConnectionFactory connectionFactory() {
            return new ActiveMQConnectionFactory("vm://localhost");
        }



        @Configuration
        static class ClientConfig {

            @Bean
            JmsTemplate jmsTemplate(
                    ConnectionFactory connectionFactory) {
                JmsTemplate jmsTemplate = new JmsTemplate();
                jmsTemplate.setConnectionFactory(connectionFactory);
                jmsTemplate.setReceiveTimeout(3000L);
                jmsTemplate.setSessionTransacted(false);
                jmsTemplate.setDeliveryPersistent(false);
                return jmsTemplate;
            }

        }
        
        @Configuration
        static class ClientConfig2 {

            @Bean
            JmsMessagingTemplate jmsMessagingTemplate(
                    JmsTemplate jmsTemplate) {
                JmsMessagingTemplate jmsMessagingTemplate = new JmsMessagingTemplate(jmsTemplate);
                return jmsMessagingTemplate;
            }

        }

        @Configuration
        @EnableJms
        static class ServiceConfig {

            @Bean
            DefaultJmsListenerContainerFactory jmsListenerContainerFactory(
                    ConnectionFactory connectionFactory) {
                DefaultJmsListenerContainerFactory factory =
                        new DefaultJmsListenerContainerFactory();
                factory.setConnectionFactory(connectionFactory);
                factory.setSessionTransacted(false);
                return factory;
            }

        }

    }
}
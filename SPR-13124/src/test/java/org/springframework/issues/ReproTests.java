package org.springframework.issues;

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
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ReproTests.Config.class)
public class ReproTests {

    @Autowired
    TodoClient todoClient;

    // OK pattern
    @Test
    public void returnJavaBeanOnService() throws JMSException {

        String xTrack = UUID.randomUUID().toString();
        Todo todo = new Todo();
        todo.setTitle("Hello JMS");
        todo.setDescription("Test message sending using JMS.");

        Todo receivedTodo = todoClient.send("TodoQueue", todo, xTrack);

        System.out.println(receivedTodo);

        Assert.assertNotNull(receivedTodo.getTodoId());

    }


    // NG(Error) pattern
    @Test
    public void returnMessageWithJavaBeanOnService() throws JMSException {

        String xTrack = UUID.randomUUID().toString();
        Todo todo = new Todo();
        todo.setTitle("Hello JMS");
        todo.setDescription("Test message sending using JMS.");

        Todo receivedTodo = todoClient.send("TodoQueue2", todo, xTrack);

        System.out.println(receivedTodo);

        Assert.assertNotNull(receivedTodo.getTodoId());

    }


    @Configuration
    @ComponentScan(value = "org.springframework.issues")
    static class Config {

        @Bean
        BrokerService brokerService() throws Exception {
            BrokerService brokerService = new BrokerService();
            return brokerService;
        }

        @Bean
        ActiveMQConnectionFactory connectionFactory() {
            return new ActiveMQConnectionFactory("vm://localhost");
        }


        @Bean
        MappingJackson2MessageConverter messageConverter() {
            MappingJackson2MessageConverter jackson2MessageConverter = new MappingJackson2MessageConverter();
            jackson2MessageConverter.setTypeIdPropertyName("typeId");
            return jackson2MessageConverter;
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

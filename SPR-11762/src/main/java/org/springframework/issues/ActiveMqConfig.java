package org.springframework.issues;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.connection.CachingConnectionFactory;
import org.springframework.jms.core.JmsTemplate;

/**
 *
 * @author Stephane Nicoll
 */
@Configuration
public class ActiveMqConfig {

	@Bean
	public ConnectionFactory connectionFactory() {
		return new CachingConnectionFactory(
				new ActiveMQConnectionFactory("failover:(tcp://127.0.0.1:61616)"));
	}

	@Bean
	public JmsTemplate jmsTemplate() {
		return new JmsTemplate(connectionFactory());
	}

}

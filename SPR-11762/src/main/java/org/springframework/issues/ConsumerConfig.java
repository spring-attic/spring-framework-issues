package org.springframework.issues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;

/**
 *
 * @author Stephane Nicoll
 */
@EnableJms
@Configuration
public class ConsumerConfig {

	@Autowired
	private ActiveMqConfig activeMqConfig;

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(activeMqConfig.connectionFactory());
		factory.setConcurrency("10");
		return factory;
	}
}

package org.springframework.issues;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ReproApp {


	// You first need to set some messages in those queues. Simply run MessageSender
	// in src/test/java. Once this app is running you can run MessageSender again
	// to put messages in the queue.

	public static void main(String[] args) {
		// This should fire the message listener
		ConfigurableApplicationContext context =
				new AnnotationConfigApplicationContext(ActiveMqConfig.class,
						ConsumerConfig.class, MessageConsumer.class);
	}

}

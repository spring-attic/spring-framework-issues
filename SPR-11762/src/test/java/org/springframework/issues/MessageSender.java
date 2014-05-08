package org.springframework.issues;

import java.io.Serializable;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

/**
 * 
 * @author Stephane Nicoll
 */
@Component
public class MessageSender {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(ActiveMqConfig.class, MessageSender.class);
		try {
			MessageSender sender = context.getBean(MessageSender.class);
			for (int i = 0; i < 100; i++)
				sender.send();
		} finally {
			context.close();
		}
	}

	private final JmsTemplate jmsTemplate;

	@Autowired
	public MessageSender(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public void send() {
		System.out.println("Sending class not found messages");
		jmsTemplate.send("class-not-found1", new SampleClassNotFoundMessageCreator());
		jmsTemplate.send("class-not-found2", new SampleClassNotFoundMessageCreator());

//		System.out.println("Sending a simple text message");
//		jmsTemplate.send("simple", new SimpleMessageCreator());
	}

	private static class SimpleMessageCreator implements MessageCreator {

		@Override
		public Message createMessage(Session session) throws JMSException {
			return session.createTextMessage("foo bar");
		}
	}

	public static class SampleClassNotFound implements Serializable {

	}

	private static class SampleClassNotFoundMessageCreator implements MessageCreator {

		@Override
		public Message createMessage(Session session) throws JMSException {
			return session.createObjectMessage(new SampleClassNotFound());
		}
	}

}

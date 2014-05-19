package org.springframework.issues;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.Session;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

public class MainThread {

	public static void main(String[] args) throws Exception {

		Topic request = new ActiveMQTopic("request");
		for (int i = 0; i < 100; i++) {
			ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("context.xml");
			ctx.start();
			
			Connection conn = null;
			Session requestSession = null;
			try {
				ConnectionFactory connFactory = (ConnectionFactory)ctx.getBean("connectionFactory");
				EchoMessageListener messageListener = ctx.getBean(EchoMessageListener.class);
				conn = connFactory.createConnection();
				requestSession = conn.createSession(false, Session.AUTO_ACKNOWLEDGE);
				MessageConsumer requestConsumer = requestSession.createConsumer(request);
				requestConsumer.setMessageListener(messageListener);
				conn.start();
				
				JmsTemplate template = ctx.getBean(JmsTemplate.class);
				template.send(request, new MessageCreator() {
					@Override
					public Message createMessage(Session session) throws JMSException {
						return session.createBytesMessage();
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				if( requestSession != null ) {
					requestSession.close();
				}
				if( conn != null ) {
					conn.close();
				}
			}
			
			ctx.close();
		}

	}

}

package org.springframework.issues;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Topic;

import org.apache.activemq.command.ActiveMQTopic;
import org.apache.log4j.Logger;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

@Service
public class EchoMessageListener implements MessageListener {

	
	private static final Logger LOG = Logger.getLogger(EchoMessageListener.class);
	
	@Resource
	private JmsTemplate template;
	
	private Topic topic;
	
	@PostConstruct
	public void start() {
		topic = new ActiveMQTopic("response");
	}
	
	@Override
	public void onMessage(Message message) {
		LOG.info("sending response");
		template.convertAndSend(topic, message);
	}
	
}

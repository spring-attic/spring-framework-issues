package org.springframework.issues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;

@Service
public class TodoClient {

    @Autowired
    JmsTemplate jmsTemplate;

    public Todo send(String destinationName, Todo todo, final String xTrack) {

        jmsTemplate.convertAndSend(destinationName, todo, new MessagePostProcessor() {
            @Override
            public Message postProcessMessage(Message message) throws JMSException {
                message.setStringProperty("X-Track", xTrack);
                return message;
            }
        });

        return Todo.class.cast(jmsTemplate.receiveAndConvert("Reply" + destinationName));
    }

}


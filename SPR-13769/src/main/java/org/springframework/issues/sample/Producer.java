package org.springframework.issues.sample;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessagePostProcessor;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;

@Service
public class Producer {

    @Autowired
    JmsTemplate jmsTemplate;
    
    public byte[] send(String destinationName, byte[] bytes) {

        jmsTemplate.convertAndSend(destinationName, bytes, new MessagePostProcessor() {
            
            public Message postProcessMessage(Message message) throws JMSException {

            	return message;
            }
        });
        
        return (byte[])jmsTemplate.receiveAndConvert("Reply" + destinationName);
        
    }
    
    public String send2(String destinationName, String text) {

        jmsTemplate.convertAndSend(destinationName, text, new MessagePostProcessor() {
            
            public Message postProcessMessage(Message message) throws JMSException {

            	return message;
            }
        });
           
        return String.class.cast(jmsTemplate.receiveAndConvert("Reply" + destinationName));
    }


}

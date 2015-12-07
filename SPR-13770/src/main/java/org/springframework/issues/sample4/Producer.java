package org.springframework.issues.sample4;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.stereotype.Service;



@Service
public class Producer {

    @Autowired
    JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    JmsTemplate jmsTemplate;
    
    
    public Message<Todo> send(String destinationName, Todo todo, final String randomId) {

        
        MessageHeaderAccessor accessor = new MessageHeaderAccessor();
        accessor.setHeader("jms_priority", 5);  // Add jms_priority to 5
        accessor.setHeader("randomId", randomId);
        Message<Todo> todoMessage = MessageBuilder
                .withPayload(todo)
                .setHeaders(accessor).build();
        
        jmsMessagingTemplate.convertAndSend(destinationName, todoMessage);

        Message<Todo> message = (Message<Todo>)jmsMessagingTemplate.receive("Reply" + destinationName);
      
       
        return message;
    }
    
   
}

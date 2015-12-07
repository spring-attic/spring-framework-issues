package org.springframework.issues.sample4;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;


@Component
public class Consumer {

    
   
    
    @JmsListener(destination = "TestQueue1", selector = "jms_priority > 4")
    @SendTo("ReplyTestQueue1")
    public Message<Todo> receive2(Message<Todo> message) throws InterruptedException {
        Object randomId = message.getHeaders().get("randomId");

        System.out.println("Received Message : " + message);
        System.out.println("Received randomId : " + randomId);

        return message;

    } 


}
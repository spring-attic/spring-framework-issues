package org.springframework.issues;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Component
public class TodoService {

    @JmsListener(destination = "TodoQueue")
    @SendTo("ReplyTodoQueue")
    public Todo receive(Message<Todo> message) throws InterruptedException {
        Todo todo = message.getPayload();
        Object xTrack = message.getHeaders().get("X-Track");

        System.out.println("Received Message : " + message);
        System.out.println("Received X-Track : " + xTrack);
        System.out.println(todo.getTitle());
        System.out.println(todo.getDescription());

        TimeUnit.SECONDS.sleep(1);

        todo.setTodoId(UUID.randomUUID().toString());

        return todo;

    }


    @JmsListener(destination = "TodoQueue2")
    @SendTo("ReplyTodoQueue2")
    public Message<Todo> receive2(Message<Todo> message) throws InterruptedException {
        Todo todo = message.getPayload();
        Object xTrack = message.getHeaders().get("X-Track");

        System.out.println("Received Message : " + message);
        System.out.println("Received X-Track : " + xTrack);
        System.out.println(todo.getTitle());
        System.out.println(todo.getDescription());

        TimeUnit.SECONDS.sleep(1);

        todo.setTodoId(UUID.randomUUID().toString());

        return MessageBuilder
                .withPayload(todo)
                .setHeader("X-Track", xTrack)
                .build();

    }

}

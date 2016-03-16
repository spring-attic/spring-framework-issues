package org.springframework.issues;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class Bar implements ApplicationEventPublisherAware {

    private ApplicationEventPublisher publisher;

    public void doWork(int index) {
        publisher.publishEvent(new ApplicationEvent(this) {});
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }
}

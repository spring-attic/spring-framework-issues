package org.springframework.issues;

import org.springframework.context.ApplicationEvent;

/**
 *
 * @author Alessandro Polverini
 */
class MyEvent extends ApplicationEvent {

    public MyEvent(Object source) {
        super(source);
    }

}

package org.springframework.issues;

import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alessandro Polverini
 */
@RestController
@Transactional
public class Controller2 implements ApplicationEventPublisherAware {

    private static final Logger logger = LoggerFactory.getLogger(Controller2.class);
    private ApplicationEventPublisher publisher;

    public Controller2() {
        logger.info("Controller2 init");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        logger.info("ApplicationContextPublisher publisher: " + publisher);
        this.publisher = publisher;
    }

    @RequestMapping("/x1")
    public Object publishClearCacheEvent() {
        publisher.publishEvent(new MyEvent(this));
        logger.info("MyEvent published");
        return "Event published";
    }

}

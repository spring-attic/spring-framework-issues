package org.springframework.issues;

import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Alessandro Polverini
 */
@Controller
public class Controller1 implements Controller1Operations, ApplicationListener<MyEvent> {

    private static final Logger logger = LoggerFactory.getLogger(Controller1.class);

    public Controller1() {
        logger.info("Controller1 init");
    }

    @Override
    public void onApplicationEvent(MyEvent e) {
        logger.info("Received MyEvent");
    }

    public Object test(String msg) {
        logger.info("Test method called");
        return "test: " + msg;
    }

}

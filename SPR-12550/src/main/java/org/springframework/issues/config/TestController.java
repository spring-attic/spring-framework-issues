package org.springframework.issues.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @RequestMapping("/forward")
    public String forward() {
        return "forward:other";
    }

    @RequestMapping("/other")
    public String other() {
        return "other";
    }
}

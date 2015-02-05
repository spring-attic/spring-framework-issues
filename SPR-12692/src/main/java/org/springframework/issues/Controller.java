package org.springframework.issues;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @RequestMapping("/test")
    public void create() {
        throw new BadRequestException("it works");
    }

}

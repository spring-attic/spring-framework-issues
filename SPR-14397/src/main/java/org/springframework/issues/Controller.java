package org.springframework.issues;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class Controller {
    @RequestMapping(value = "",
        method = { RequestMethod.POST },
        consumes = { MediaType.APPLICATION_JSON_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    public String post1() {
        return "Accept: JSON";
    }

    @RequestMapping(value = "",
        method = { RequestMethod.POST },
        consumes = { MediaType.TEXT_PLAIN_VALUE },
        produces = { MediaType.APPLICATION_JSON_VALUE }
    )
    public String post2() {
        return "Accept: TEXT";
    }
}

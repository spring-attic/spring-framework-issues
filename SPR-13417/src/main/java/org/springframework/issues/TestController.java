package org.springframework.issues;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    @RequestMapping(name= "/test", method = RequestMethod.POST)
    @ResponseBody
    public String handle(@RequestBody(required = false) String body) {
        return "OK";
    }

    @RequestMapping(name= "/testjson", method = RequestMethod.POST,
            produces = "application/json", consumes = "application/json")
    @ResponseBody
    public String handle(@RequestBody(required = false) Book body) {
        return "OK";
    }

    public class Book {
        String title;
        String author;
    }
}

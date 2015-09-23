package org.springframework.issues;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(new PayloadValidator());
    }

    @RequestMapping("/")
    public String emptyBody(@RequestBody @Validated Payload payload) {
        return "hello";
    }
}

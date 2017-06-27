package org.springframework.issues.errorhandling;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    public static final String ERROR_MSG = "An error occurred!";

    @RequestMapping("/hello")
    public String hello() {
        final NestedException nested = new NestedException("nested");
        throw new CustomException("outer", nested);
    }

    @ExceptionHandler()
    public String handleCustomException(final CustomException e) {
        return ERROR_MSG;
    }
}

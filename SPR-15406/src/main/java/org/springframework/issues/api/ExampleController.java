package org.springframework.issues.api;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExampleController {
	
    @RequestMapping(value = "serviceUnavailable", method = RequestMethod.GET)
    public void responseServiceUnavailable(HttpServletResponse response) throws IOException {
        response.sendError(503);
    }
}

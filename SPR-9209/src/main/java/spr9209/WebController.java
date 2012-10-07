package spr9209;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class WebController {

    @RequestMapping("/request1")
    public void handleRequest1() {
        throw new NullPointerException();
    }

    @RequestMapping("/request2")
    public void handleRequest2() {
        throw new IllegalArgumentException();
    }

    @RequestMapping("/ping")
    @ResponseBody
    public String ping() {
        return "pong";
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public void iaeHandler(HttpServletResponse response) {
        try {
            response.getWriter().println("Handling IllegalArgumentException");
        } catch (IOException e) {
            //ignore
        }
    }
}

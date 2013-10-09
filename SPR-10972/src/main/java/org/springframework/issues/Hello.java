package org.springframework.issues;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Hello {

    @Autowired ScopedComponent comp;

    @RequestMapping("/")
    @ResponseBody String hello(HttpServletRequest req) {
        return comp.getGreeting()+" "+req.getSession().getId();
    }
}

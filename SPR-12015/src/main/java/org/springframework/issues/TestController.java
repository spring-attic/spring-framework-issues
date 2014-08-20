package org.springframework.issues;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * User: seveniu
 * Date: 8/20/14
 * Time: 11:16 AM
 * Project: SPR-9990
 */
@Controller
public class TestController {
    @RequestMapping("/test/{value}")
    @ResponseBody
    public String test(@PathVariable("value")String value) {
        return value;
    }
}

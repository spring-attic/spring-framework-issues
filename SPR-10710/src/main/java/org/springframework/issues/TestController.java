package org.springframework.issues;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

@Controller
public class TestController {

    @RequestMapping(value="/test")
    @ResponseBody
    public DeferredResult<String> test() {
        return new DeferredResult<String>(50L, "timeout\n");
    }

}

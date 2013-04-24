package org.springframework.issues;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

@Controller
public class TestController {
    private DeferredResult<String> deferred;

    static class DoSomethingUseful implements Runnable {
        public void run() {
            try { Thread.sleep(2000); } catch (InterruptedException e) { }
        }
    }

    @RequestMapping(value="/test/start")
    @ResponseBody
    public DeferredResult<String> start() {
        deferred = new DeferredResult<String>(4000L, "timeout\n");
        deferred.onTimeout(new DoSomethingUseful());
        return deferred;
    }

    @RequestMapping(value="/test/stop")
    @ResponseBody
    public String stop() {
        deferred.setResult("result\n");
        return "ok\n";
    }
}

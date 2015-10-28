package org.springframework.issues;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.async.DeferredResult;

@Controller
public class DummyController {

    private ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

    @RequestMapping("/dummyCallable")
    public Callable<String> callable() {
        return () -> "Dummy";
    }

    @RequestMapping("/dummyDeferred")
    public DeferredResult<String> deferred() {
        DeferredResult<String> r = new DeferredResult<>();
        executorService.schedule(() -> r.setResult("Dummy"), 10, TimeUnit.MILLISECONDS);
        return r;
    }
}

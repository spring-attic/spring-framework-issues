package org.springframework.issues;

import org.springframework.beans.factory.InitializingBean;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Foo implements InitializingBean {

    private final Bar bar;

    public Foo(Bar bar) {
        this.bar = bar;
    }

    public Bar getBar() {
        return this.bar;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        CompletableFuture.allOf(IntStream.range(1, Runtime.getRuntime().availableProcessors() + 1)
                                         .mapToObj((index) -> CompletableFuture.runAsync(() -> bar.doWork(index)))
                                         .toArray(CompletableFuture[]::new))
                         .get();
    }
}

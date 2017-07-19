package io.pivotal.webflux;

import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 *
 */
public class ClientApplication {

    public static void main(String[] args) {
        WebClient client = WebClient.create("http://localhost:8080");
        Flux<WebfluxApplication.Pojo> pojoFlux = client.get().uri("/dummy").retrieve().bodyToFlux(WebfluxApplication.Pojo.class);
        pojoFlux.count().block();
    }
}

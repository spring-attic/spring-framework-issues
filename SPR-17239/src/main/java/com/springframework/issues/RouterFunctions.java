package com.springframework.issues;

import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

public interface RouterFunctions {

    static RouterFunction<?> router() {
        return nest(accept(APPLICATION_JSON),
                route(GET("/test"),
                        req -> Mono
                                .error(new IllegalArgumentException())
                                .flatMap(a -> ServerResponse.ok().build())));
    }
}

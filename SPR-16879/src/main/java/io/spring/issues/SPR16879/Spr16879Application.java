package io.spring.issues.SPR16879;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@SpringBootApplication
public class Spr16879Application {

    public static void main(String[] args) {
        SpringApplication.run(Spr16879Application.class, args);
    }

    @Bean
    public RouterFunction<ServerResponse> routerFunction() {
        return nest(path("/test/{something}"),
                route(GET("/info"), this::variables)
                        .andRoute(GET("/info/{foo}"), this::variables))
                .andRoute(method(HttpMethod.GET), this::variables);
    }

private Mono<ServerResponse> variables(ServerRequest request) {
    return ServerResponse.ok().body(fromObject(request.pathVariables()));
}

}

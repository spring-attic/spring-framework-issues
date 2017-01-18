package org.springframework.issues;


import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.ipc.netty.http.server.HttpServer;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RouterFunctions.toHttpHandler;


public class Server {

    static final String HOST = "localhost";

    static final int PORT = 8080;

    private static List<Person> personList = new ArrayList<>();

    static {
        personList.add(new Person("John", 36));
        personList.add(new Person("Valentine", 12));
    }

    private static RouterFunction<?> routingFunction() {
        return route(GET("/person").and(accept(APPLICATION_JSON)),
                (request) -> ServerResponse
                        .ok()
                        .headers(request.headers().asHttpHeaders())
                        .contentType(APPLICATION_JSON)
                        .body(Flux.fromIterable(personList), Person.class));
    }

    static void startReactorServer() throws InterruptedException {
        RouterFunction<?> route = routingFunction();
        HttpHandler httpHandler = toHttpHandler(route);
        ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(httpHandler);
        HttpServer server = HttpServer.create(HOST, PORT);
        server.newHandler(adapter).block();
    }

    public static void main(String[] args) throws Exception {
        startReactorServer();

        System.out.println("Press ENTER to exit.");
        System.in.read();
    }

}
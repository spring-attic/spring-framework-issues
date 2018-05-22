package io.spring.issues.SPR16846;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;
import static org.springframework.web.reactive.function.server.RouterFunctions.*;

@SpringBootApplication
public class Spr16846Application {

	public static void main(String[] args) {
		SpringApplication.run(Spr16846Application.class, args);
	}

	@Bean
	public RouterFunction<?> routerFunction() {
		return route(POST("/test"),
				request -> request.bodyToMono(String.class)
						.doOnNext(System.out::println)
						.then(ServerResponse.ok().build()));
	}

}

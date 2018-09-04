package com.springframework.issues;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.server.HandlerStrategies;
import org.springframework.web.server.i18n.FixedLocaleContextResolver;

import java.util.Locale;

public class RouterFunctionsTest {

    private WebTestClient webClient;

    @BeforeEach
    public void setUp() {
        this.webClient = WebTestClient
                .bindToRouterFunction(RouterFunctions.router())
                .handlerStrategies(HandlerStrategies.builder()
                        .exceptionHandler(new ExceptionHandler())
                        .localeContextResolver(new FixedLocaleContextResolver(Locale.ENGLISH))
                        .build())
                .build();
    }

    @Test
    public void test() {
        webClient
                .get()
                .uri("/test")
                .exchange()
                .expectStatus().isOk()
                .expectBody().isEmpty();
    }
}

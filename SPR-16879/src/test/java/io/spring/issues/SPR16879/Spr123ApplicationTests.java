package io.spring.issues.SPR16879;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@WebFluxTest
public class Spr123ApplicationTests {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    public void testNestedPathRequestPredicateWithoutPathVariable() {
        this.webTestClient.get().uri("/test/spring/info")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .json("{\"something\":\"spring\"}");
    }

    @Test
    public void testNestedPathRequestPredicateWithPathVariable() {
        this.webTestClient.get().uri("/test/spring/info/bar")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("{\"something\":\"spring\",\"foo\":\"bar\"}");
    }

    @Test
    public void testPathRequestPredicateWithoutPathVariable() {
        this.webTestClient.get().uri("/test/spring")
                .exchange()
                .expectStatus().isOk()
                .expectBody(String.class)
                .isEqualTo("{}");
    }
}
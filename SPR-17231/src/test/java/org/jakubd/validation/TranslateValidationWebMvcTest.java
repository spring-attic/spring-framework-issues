package org.jakubd.validation;

import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest(
        properties = "spring.main.web-application-type: servlet",
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class TranslateValidationWebMvcTest {

    @LocalServerPort
    int port;

    @Test
    public void should_translate_error_to_polish() {
        // when
        ClientResponse response = WebClient.create().post()
                .uri("http://localhost:" + port + "/validate")
                .header("Accept-Language", "pl-PL")
                .body(Mono.just(new TestBody()), TestBody.class)
                .exchange()
                .block();

        // then
        Map body = response.bodyToMono(Map.class).block();

        String message = (String) ((Map) (((List) body.get("errors")).get(0))).get("defaultMessage");
        Assertions.assertThat(message).isEqualTo("musi być podane");
    }

}

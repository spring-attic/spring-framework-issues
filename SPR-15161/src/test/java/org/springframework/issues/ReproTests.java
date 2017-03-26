package org.springframework.issues;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.reactive.function.client.ClientRequest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.List;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ReproTests {


    private WebClient client = WebClient.create(new ReactorClientHttpConnector());


    @BeforeClass
    public static void startserver() throws Exception {
        Server.startReactorServer();
    }

    @Test
    public void repro() {
        ClientRequest<Void> request = ClientRequest.GET("http://{host}:{port}/person",
                Server.HOST, Server.PORT).build();

        Flux<Person> people = client.exchange(request)
                .flatMap(response -> response.bodyToFlux(Person.class))
                .doOnEach(System.out::println);

        StepVerifier.create(people)
                .expectNext(new Person("John", 36))
                .expectNext(new Person("Valentine", 12))
                .expectComplete()
                .verify();
    }

}

package org.springframework.issues.errorhandling;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;

/**
 * Created by dorongold on 6/24/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloControllerTest {

    /*
    * First run the Application as a separate process, then run this test which sends a request to the listening web app.
    * The web app returns a response with status code 500
     */
    @Test
    public void testHello() {

        WebClient.create()
                .get()
                .uri("http://localhost:8080/error")
                .retrieve()
                .toEntity(String.class)
                .map(responseEntity -> {
                    //never reaches here because the underlying reactor.ipc.netty.http.client.HttpClient
                    // emits an error Mono from reactor.ipc.netty.http.client.HttpClientOperations#checkResponseCode()
                    if (responseEntity.getStatusCode()
                            .is5xxServerError()) {
                        throw new RuntimeException("Custom Server Error Exception");
                    }
                    return responseEntity.getBody();
                })
                .block();
    }
}

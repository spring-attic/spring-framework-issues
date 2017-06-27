package org.springframework.issues.errorhandling;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * Created by dorongold on 6/24/17.
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebTestClient
public class HelloControllerTest {

    @Autowired
    private WebTestClient client;

    /*
     * fails because exception handler invocation fails with "java.lang.IllegalStateException: No suitable resolver
     * for argument 0 of type..."
     */
    @Test
    public void testHello() {

        final String response = client.get().uri("hello").exchange().expectBody(String.class).returnResult().getResponseBody();
        assertEquals(HelloController.ERROR_MSG, response);
    }

}

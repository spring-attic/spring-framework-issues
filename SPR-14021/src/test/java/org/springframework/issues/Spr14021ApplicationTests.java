package org.springframework.issues;

import com.jayway.restassured.RestAssured;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static com.jayway.restassured.RestAssured.*;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Value;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Spr14021Application.class)
@WebAppConfiguration
@IntegrationTest("server.port:0")
public class Spr14021ApplicationTests {

    @Value("${local.server.port}")   // 6
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void requestParamIsPassed() {
        when()
              .get("/person?pageSize=1&pageNum=2&query=3")
        .then()
                .statusCode(HttpStatus.SC_OK)
                .body(Matchers.equalToIgnoringCase("pageNum: 2, pageSize: 1, query: 3"));
    }

    @Test
    public void pathVariableIsPassed() {
        when()
              .get("/person/asm0dey/")
        .then()
                .statusCode(HttpStatus.SC_OK)
                .body(Matchers.equalToIgnoringCase("asm0dey"));
    }

}

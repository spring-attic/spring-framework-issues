package org.springframework.issue;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Collections;
import java.util.List;

@RestController
@SpringBootApplication
public class Application {

    public Application() {
        // default constructor is needed by Spring
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @RequestMapping("/fail")
    public Flux<TestDTO> fail() {
        return WebClient.builder().baseUrl("http://localhost:8080")
                .build().get().uri("/empty")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flux()
                .flatMap(clientResponse -> clientResponse.bodyToFlux(TestDTO.class));
    }

    @RequestMapping("/success")
    public Flux<TestDTO> sucess() {
        return WebClient.builder().baseUrl("http://localhost:8080")
                .build().get().uri("/single")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .flux()
                .flatMap(clientResponse -> clientResponse.bodyToFlux(TestDTO.class));
    }

    @RequestMapping("/empty")
    public List<TestDTO> emptyArray() {
        return Collections.emptyList();
    }

    @RequestMapping("/single")
    public List<TestDTO> singleItem() {
        return Collections.singletonList(new TestDTO("1"));
    }

    public static class TestDTO {
        private String id;

        @JsonCreator
        public TestDTO(@JsonProperty("id") String id) {
            this.id = id;
        }

        @JsonProperty("id")
        public String getId() {
            return id;
        }
    }
}

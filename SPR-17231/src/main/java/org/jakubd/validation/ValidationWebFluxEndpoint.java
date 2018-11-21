package org.jakubd.validation;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

import static org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication.Type.REACTIVE;

@RestController
@RequestMapping("/validate")
@ConditionalOnWebApplication(type = REACTIVE)
public class ValidationWebFluxEndpoint {

    @PostMapping
    public Mono<Void> validated(@RequestBody @Valid Mono<TestBody> body) {
        return body.then();
    }

}

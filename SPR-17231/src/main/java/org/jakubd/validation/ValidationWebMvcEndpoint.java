package org.jakubd.validation;

import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication.Type.SERVLET;

@RestController
@RequestMapping("/validate")
@ConditionalOnWebApplication(type = SERVLET)
public class ValidationWebMvcEndpoint {

    @PostMapping
    public void validated(@RequestBody @Valid TestBody body) {
    }
}

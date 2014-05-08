package org.springframework.issues.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class GateController {

    private static final Logger logger = LoggerFactory.getLogger(GateController.class);
    private static final String X_HTTP_STATUS_OVERRIDE = "X-HTTP-Status-Override";

    // ...

    @RequestMapping
    public ResponseEntity<String> invalidRequestUriHandler(HttpServletRequest request) {
        IllegalArgumentException ex = new IllegalArgumentException(request.getRequestURI());
        logger.info("", ex);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.set(X_HTTP_STATUS_OVERRIDE, "230");
        return new ResponseEntity<>("", httpHeaders, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

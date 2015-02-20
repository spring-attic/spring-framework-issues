package org.springframework.issues;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "bad request")
public class BadRequestException extends IllegalArgumentException {

    public BadRequestException(String message) { super(message); }

}

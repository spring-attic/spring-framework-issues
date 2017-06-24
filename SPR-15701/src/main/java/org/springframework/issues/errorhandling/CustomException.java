package org.springframework.issues.errorhandling;

/**
 * Created by dorongold on 6/23/17.
 */
public class CustomException extends RuntimeException {

    public CustomException(final String message, final Throwable cause) {
        super(message, cause);
    }
}

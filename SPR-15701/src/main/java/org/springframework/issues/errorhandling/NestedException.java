package org.springframework.issues.errorhandling;

/**
 * Created by dorongold on 6/23/17.
 */
public class NestedException extends Exception {

    public NestedException(final String message) {
        super(message);
    }
}

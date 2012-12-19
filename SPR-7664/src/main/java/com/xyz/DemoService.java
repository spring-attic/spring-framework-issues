package com.xyz;

/**
 * @author borisb
 */
public abstract class DemoService {

    @Secured("QWERTY")
    public abstract Object secureMethod(String firstName, String lastName);

    public abstract Object unsecureMethod(String firstName, String lastName);
}

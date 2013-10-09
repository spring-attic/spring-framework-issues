package org.springframework.issues;

import java.io.Serializable;

public class ScopedComponent implements Serializable {
    private static final long serialVersionUID = -5231285689411021755L;

    private String greeting = "Hello";

    @AdivseMe
    public String getGreeting() {
        return greeting;
    }

    void setGreeting(String greeting) {
        this.greeting = greeting;
    }
}

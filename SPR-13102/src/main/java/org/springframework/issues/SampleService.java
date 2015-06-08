package org.springframework.issues;

public class SampleService {

    /**
     * Not matched method on {@link LoggingAspect}.
     */
    public void execute(SampleInputBean inputBean) {
        System.out.println(getClass().getName() + "#execute(SampleInputBean) called.");
    }

    /**
     * Matched method on {@link LoggingAspect}
     * <p>
     * The SampleDto class have a {@link Loggable} annotation.
     */
    public void execute(SampleDto dto) {
        System.out.println(getClass().getName() + "#execute(SampleDto) called.");
    }

}

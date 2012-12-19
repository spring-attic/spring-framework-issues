package com.xyz;

/**
 * @author borisb
 */
public class DemoServiceImpl extends DemoService {

    @Override
    public Object secureMethod(String firstName, String lastName) {
        return "result";
    }

    @Override
    public Object unsecureMethod(String firstName, String lastName) {
        return "result2";
    }
}

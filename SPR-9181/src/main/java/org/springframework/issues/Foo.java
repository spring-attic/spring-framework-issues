package org.springframework.issues;

import javax.inject.Provider;


public class Foo {

    Provider<ProviderClass<String, String>> testProvider;

    public Foo(Provider<ProviderClass<String, String>> testProvider) {
        this.testProvider = testProvider;
    }

    public ProviderClass getProviderClass(){
        return testProvider.get();
    }
}

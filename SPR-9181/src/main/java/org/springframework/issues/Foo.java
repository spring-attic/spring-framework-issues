package org.springframework.issues;

import javax.inject.Provider;


public class Foo {

	Provider<ProviderClass> testProvider;

	public Foo(Provider<ProviderClass> testProvider) {
		this.testProvider = testProvider;
	}

	public ProviderClass getProviderClass(){
		return testProvider.get();
	}
}

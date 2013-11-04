package org.springframework.issues;


public class DefaultFooService implements FooService {
	
	@Override
	public String get() throws Throwable {
		return "bar";
	}
}

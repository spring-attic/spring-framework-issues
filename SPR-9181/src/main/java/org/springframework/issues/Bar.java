package org.springframework.issues;

import org.springframework.context.annotation.Scope;

import javax.inject.Inject;
import javax.inject.Named;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Named
@Scope(SCOPE_PROTOTYPE)
public class Bar {

	Foo foo;

	@Inject
	public Bar(@Named("testFactory") Foo foo){
		this.foo = foo;
	}

	public Foo getFoo(){
		return foo;
	}
}

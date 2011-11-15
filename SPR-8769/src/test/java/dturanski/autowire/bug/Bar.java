package dturanski.autowire.bug;

import org.springframework.beans.factory.annotation.Autowired;

public class Bar {
	@Autowired
	Foo foo;
	
	public void setFoo(Foo foo) {
		this.foo = foo;
	}
}

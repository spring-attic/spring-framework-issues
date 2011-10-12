package dturanski.autowire.bug;

public class FooFactory {
	public static Foo init() {
		System.out.println("called init()");
		return new FooImpl();
	}
}

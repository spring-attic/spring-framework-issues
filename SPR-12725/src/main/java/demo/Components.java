package demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author Stephane Nicoll
 */
@Configuration
public class Components {

	@Component
	static class FooListener {

		@EventListener
		public Bar handle(Foo foo) {
			System.out.println("Got foo: " + foo);
			return new Bar();
		}
	}

	@Component
	static class BarListener {

		@EventListener
		public void handle(Bar bar) {
			System.out.println("Got bar: " + bar);
		}
	}

	static class Foo {}

	static class Bar {}
}

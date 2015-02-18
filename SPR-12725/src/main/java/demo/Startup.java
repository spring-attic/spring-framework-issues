package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 *
 * @author Stephane Nicoll
 */
@Component
public class Startup implements CommandLineRunner {

	private final ApplicationEventPublisher publisher;

	@Autowired
	public Startup(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public void run(String... strings) throws Exception {
		this.publisher.publishEvent(new Components.Foo());
	}
}

package org.springframework.issues;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 *
 * @author Stephane Nicoll
 */
@Component
public class MessageConsumer {

	@JmsListener(destination = "simple")
	public void handleSimple(Object o) {
		System.out.println("Received " + o);
	}

	@JmsListener(destination = "class-not-found-1")
	public void handle1(Object o) {
		System.out.println("Received (one) " + o);
	}

	@JmsListener(destination = "class-not-found-2")
	public void handle2(Object o) {
		System.out.println("Received (two) " + o);
	}
}

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

	@JmsListener(destination = "class-not-found")
	public void handle(Object o) {
		System.out.println("Received " + o);
	}

	public static class MessageReceiver1 {
		public void receiveMessage(Object o) {
			System.out.println("Received " + o);
		}
	}

	public static class MessageReceiver2 {
		public void receiveMessage(Object o) {
			System.out.println("Received " + o);
		}
	}
}

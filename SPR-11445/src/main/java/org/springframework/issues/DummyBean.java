package org.springframework.issues;

import java.util.concurrent.atomic.AtomicInteger;


public class DummyBean {

	private final AtomicInteger calls = new AtomicInteger();

	public int getCalls() {
		return calls.getAndIncrement();
	}
}

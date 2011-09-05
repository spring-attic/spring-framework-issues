package org.springframework.issues;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;

@Repository
public class MyRepositoryImpl implements MyRepository {

	private final AtomicInteger count = new AtomicInteger(0);

	@Scheduled(fixedDelay = 5)
	public void scheduled() {
		this.count.incrementAndGet();
	}

	@Override
	public int getInvocationCount() {
		return this.count.get();
	}
}
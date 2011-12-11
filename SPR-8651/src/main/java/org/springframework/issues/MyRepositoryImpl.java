package org.springframework.issues;

import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class MyRepositoryImpl implements MyRepository {

	private final AtomicInteger count = new AtomicInteger(0);

	@Transactional
	@Scheduled(fixedDelay = 5)
	public void scheduled() {
		this.count.incrementAndGet();
	}

	@Override
	public int getInvocationCount() {
		return this.count.get();
	}
}
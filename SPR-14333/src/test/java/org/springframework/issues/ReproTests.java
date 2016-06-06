package org.springframework.issues;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within need not pass with the green bar!
 * Rather they should fail in such a way that demonstrates the reported issue.
 */
public class ReproTests {

	@Test
	public void repro() throws Exception {

		ExecutorService executor = Executors.newCachedThreadPool();
		try {

			/*
			 * Since this is a concurrency issue, we need to try hard several times.
			 */
			int tries = 10000;

			for (int i = 0; i < tries; ++i) {

				GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
				ctx.load("classpath:org/springframework/issues/ReproTests-context.xml");
				ctx.refresh();

				/*
				 * Use variable number of threads. Particularily, first round uses 1 thread, so must pass, otherwise
				 * test setup is corrupted.
				 */
				int threads = 1 + (i % 4);
				System.out.printf("attempt %s (0-based), threads: %s\n", i, threads);

				CyclicBarrier sync = new CyclicBarrier(threads);
				List<Future<?>> futures = new ArrayList<>();
				for (int th = 0; th < threads; ++th) {
					Future<?> future = executor.submit(() -> {
						sync.await(10, TimeUnit.SECONDS);
						Foo foo = ctx.getBean(Foo.class);
						Assert.assertNotNull("foo.getBar", foo.getBar());
						return null;
					});
					futures.add(future);
				}

				for (Future<?> future : futures) {
					future.get();
				}

				ctx.close();
			}

		} finally {
			executor.shutdownNow();
		}
	}

}

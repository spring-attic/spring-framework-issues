package org.springframework.issues;

import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.hamcrest.CoreMatchers;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within need not pass with the green bar!
 * Rather they should fail in such a way that demonstrates the reported issue.
 */
public class ReproTests {

	private static final int TIMES = 10000;

	ExecutorService executor;

	@Test
	public void checkTestSanity() throws Exception {
		executor = Executors.newCachedThreadPool();
		try {
			for (int i = 0; i < TIMES; ++i) {
				if (i % 100 == 0) System.out.println(i);
				reproOnce(1);
			}

		} finally {
			executor.shutdownNow();
		}
	}

	@Test
	public void repro() throws Exception {
		executor = Executors.newCachedThreadPool();
		try {
			for (int i = 0; i < TIMES; ++i) {
				if (i % 100 == 0) System.out.println(i);
				try {
					reproOnce(4);

				} catch (Error e) {
					throw new Error("Failed at " + i, e);

				} catch (Exception e) {
					throw new Exception("Failed at " + i, e);
				}
			}

		} finally {
			executor.shutdownNow();
		}
	}

	private void reproOnce(int threads) throws Exception {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("classpath:org/springframework/issues/ReproTests-context.xml");
		ctx.refresh();

		List<Foo> foos = getFoos(ctx, threads);
		for (Foo foo : foos) {
			assertThat(foo.getBar(), CoreMatchers.notNullValue());
		}
	}

	private List<Foo> getFoos(GenericXmlApplicationContext ctx, int threads) throws Exception {
		List<Callable<List<Foo>>> callables = new ArrayList<Callable<List<Foo>>>();
		for (int i = 0; i < threads; ++i) {
			callables.add(new GetFoos(ctx));
		}

		List<Future<List<Foo>>> results = executor.invokeAll(callables);

		List<Foo> foos = new ArrayList<Foo>();
		for (Future<List<Foo>> future : results) {
			foos.addAll(future.get());
		}

		return foos;
	}

	private static class GetFoos implements Callable<List<Foo>> {

		final GenericXmlApplicationContext ctx;

		public GetFoos(GenericXmlApplicationContext ctx) {
			super();
			this.ctx = ctx;
		}

		@Override
		public List<Foo> call() throws Exception {
			List<Foo> foos = new ArrayList<Foo>();
			foos.add((Foo) ctx.getBean("foo"));
			foos.add((Foo) ctx.getBean("foo"));
			foos.add((Foo) ctx.getBean("foo"));
			foos.add((Foo) ctx.getBean("foo"));
			foos.add((Foo) ctx.getBean("foo"));
			return foos;
		}
	}
}

package org.springframework.issues;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;




@Component("asyncProcessCopy")
public class CopyOfAsyncProcess implements AsyncProcessInterface {

	@Autowired
	@Qualifier("portalAsyncExecutor")
	ThreadPoolTaskExecutor taskExecutor;

	public Future<String> findBalanceAsync(final String account) {
		return taskExecutor.submit(new CopyOfAsyncTask(account));

	}

	private class CopyOfAsyncTask implements Callable<String> {

		private String account;

		CopyOfAsyncTask(String account) {
			this.account = account;
		}

		
		public String call() throws Exception {
			long startTime = System.currentTimeMillis();

			String threadName = Thread.currentThread().getName();

			long t = System.currentTimeMillis();
			long end = t + 10000;// 15 seconds
			if (account.equals("portlet2")) {
				end = t + 45000;
			}
			while (System.currentTimeMillis() < end) {
				// do something
				// pause to avoid churning

			}
			long endTime = System.currentTimeMillis();
			String balance = Long.valueOf(endTime).toString()+" : "+threadName;
			System.out.println(threadName + " completes Async processing : "
					+ (endTime - startTime) / 1000 + " seconds for " + account);
			return balance;

		}

	}

}

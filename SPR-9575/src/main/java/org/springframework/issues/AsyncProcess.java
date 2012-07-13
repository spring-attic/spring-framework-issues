package org.springframework.issues;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;



@Component("asyncProcess")
public class AsyncProcess implements AsyncProcessInterface {

	/* (non-Javadoc)
	 * @see com.solutionary.service.AsyncProcessInterface#findBalanceAsync(java.lang.String)
	 */
	//("portalAsyncExecutor")
	
	@Async("portalPoolTaskExecutor")
	public Future<String> findBalanceAsync(final String account) {
		long startTime = System.currentTimeMillis();
	
		 String threadName = Thread.currentThread().getName();
	 

		long t= System.currentTimeMillis();
		long end = t+10000;//15 seconds
		if (account.equals("portlet2")){
			 end = t+45000;
		}
		while(System.currentTimeMillis() < end) {
		  // do something
		  // pause to avoid churning
		  
		}
		long endTime = System.currentTimeMillis();
		String balance = Long.valueOf(endTime).toString()+" : "+threadName;
		System.out.println(threadName+" completes Async processing : "
				+ (endTime - startTime) / 1000 + " seconds for " + account);
		return new AsyncResult<String>(balance);
	}

}

package org.springframework.issues;


import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;




@Service("asyncService")
public class AsyncService {
//@Qualifier("asyncProcessCopy")
	@Autowired
	@Qualifier("asyncProcess")
	private AsyncProcessInterface asyncProcess;

	
	
	@Autowired
	@Qualifier("portletCache")
	private PortletCacheInterface portletCache;

	public ResultDto findBalanceAsync(String targetDiv) throws Exception {
		
		Future<String> future;
		ResultDto dto = new ResultDto();
		future =  portletCache.get(targetDiv);
		if (future==null) {
			System.out.println("is asyncProcess an @Async proxy? " + AopUtils.isAopProxy(asyncProcess));
			future = asyncProcess.findBalanceAsync(targetDiv);
			portletCache.put(targetDiv, future);
		} 
		String result = "";
		try {
			result = future.get(3, TimeUnit.SECONDS);
			dto.setContent(result);
			dto.setProcessCode(ResultCode.COMPLETE);
			portletCache.remove(targetDiv);
		} catch (InterruptedException e) {
			e.printStackTrace();
			dto.setProcessCode(ResultCode.ERROR);
		} catch (ExecutionException e) {
			e.printStackTrace();
			dto.setProcessCode(ResultCode.ERROR);
		} catch (TimeoutException e) {
			result = "Processing ...";
			dto.setContent(result);
			dto.setProcessCode(ResultCode.PROCESSING);
			
		}
		long size = portletCache.getSize();
		System.out.println("Cache Size: "+size+"; Result: "+result);
		
		return dto;
	}
}

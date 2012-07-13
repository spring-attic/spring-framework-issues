package org.springframework.issues;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;
import org.springframework.stereotype.Component;


import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;



@Component("portletCache")
@ManagedResource(objectName="bean:name=PortletCacheBean", description="PortalCache Bean")
public class PortletCache implements PortletCacheInterface {

	
	 
	 
	private Cache<String,Future<String>> cache;


	/* (non-Javadoc)
	 * @see com.solutionary.cache.PortletCacheInterface#exists(java.lang.String)
	 */
	
	public boolean exists(String key){
		
		return cache.getIfPresent(key)!=null;
	}
	
	/* (non-Javadoc)
	 * @see com.solutionary.cache.PortletCacheInterface#get(java.lang.String)
	 */

	public Future<String> get(String key){
		return cache.getIfPresent(key);
	}
	
	/* (non-Javadoc)
	 * @see com.solutionary.cache.PortletCacheInterface#put(java.lang.String, java.util.concurrent.Future)
	 */
	
	public void put(String key, Future<String> future){
		cache.put(key, future);
	}
	
	/* (non-Javadoc)
	 * @see com.solutionary.cache.PortletCacheInterface#getSize()
	 */
	
	@ManagedAttribute(description="Cache Size")
	public long getSize(){
		return cache.size();
	}

	
	/* (non-Javadoc)
	 * @see com.solutionary.cache.PortletCacheInterface#cleanUp()
	 */
	
	@ManagedOperation(description="Flush Cache")
	public void cleanUp(){
		cache.cleanUp();
	}
	
	/* (non-Javadoc)
	 * @see com.solutionary.cache.PortletCacheInterface#initialize()
	 */
	
	@PostConstruct
	  public void initialize() {
		PortletCacheListener listener = new PortletCacheListener();
		cache = CacheBuilder.newBuilder().concurrencyLevel(4).softValues().maximumSize(60).removalListener(listener).expireAfterWrite(2, TimeUnit.MINUTES).build();
				
	  }

	/* (non-Javadoc)
	 * @see com.solutionary.cache.PortletCacheInterface#remove(java.lang.String)
	 */

	public void remove(String targetDiv) {
		cache.invalidate(targetDiv);
		
		
	}
	
}
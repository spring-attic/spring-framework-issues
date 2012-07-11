package org.springframework.issues;

import com.google.common.cache.RemovalListener;
import com.google.common.cache.RemovalNotification;

public class PortletCacheListener implements RemovalListener<String,Object> {

	
	public void onRemoval(RemovalNotification<String, Object> arg0) {
		System.out.println(arg0.getKey() + " has been altered");
	}

}

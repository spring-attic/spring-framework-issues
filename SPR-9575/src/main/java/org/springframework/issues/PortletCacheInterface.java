package org.springframework.issues;

import java.util.concurrent.Future;

public interface PortletCacheInterface {

	void remove(String targetDiv);

	long getSize();

	void put(String targetDiv, Future<String> future);

	Future<String> get(String targetDiv);

}

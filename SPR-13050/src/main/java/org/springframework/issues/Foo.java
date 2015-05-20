package org.springframework.issues;

import java.util.HashMap;
import java.util.Map;

public class Foo {

	Map<Long,Object> objectMap = new HashMap<Long,Object>();

	public Map<Long, Object> getObjectMap() {
		return objectMap;
	}

	public void setObjectMap(Map<Long, Object> objectMap) {
		this.objectMap = objectMap;
	}

}
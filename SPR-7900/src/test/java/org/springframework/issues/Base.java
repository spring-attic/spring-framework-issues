package org.springframework.issues;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;

class Base {

	private boolean resourceInjected;

	@Resource
	public void setResource(Injectable injectable) {
		resourceInjected = true;
	}

	public boolean isResourceInjected() {
		return resourceInjected;
	}

	private boolean autowiredInjected;

	@Autowired
	public void setAutowired(Injectable injectable) {
		autowiredInjected = true;
	}

	public boolean isAutowiredInjected() {
		return autowiredInjected;
	}

}

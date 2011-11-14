package org.springframework.web.issues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope("session")
@Component
public class SimpleBean {
	@Autowired
	private MyBeanClass myBean;

	static public MyBeanClass init() {
		return null;
	}

	public MyBeanClass getMyBean() {
		return myBean;
	}

	static public class MyBeanClass {

	}
}

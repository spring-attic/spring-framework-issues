package org.springframework.web.issues;

public class SimpleBean {

	static public MyBeanClass init() {
		return null;
	}

	static public class MyBeanClass {

		public String getFoo() {
			return "foo";
		}

	}
}

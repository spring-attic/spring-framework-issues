package org.springframework.issues.sub;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class FooController {

	@Autowired
	private FooBean bean;

	public FooBean getBean() {
		return bean;
	}
}

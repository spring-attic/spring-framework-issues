package com.pivotal.demos;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Object1 {

	@NotNull
	@Size(max=2)
	private String param1;

	@Valid
	@Size(max=2)
	private List<Object2> subObjs = new ArrayList<Object2>();

	public Object1() {
		for (int i = 0; i < 30; i++) {
			Object2 obj = new Object2();
			obj.setParam1("param1-" + i);
			obj.setParam2("param2-" + i);
			obj.setParam3("param3-" + i);
			obj.setParam4("param4-" + i);
			subObjs.add(obj);
		}
	}

	public String getParam1() {
		return param1;
	}
	public void setParam1(String param1) {
		this.param1 = param1;
	}
	public List<Object2> getSubObjs() {
		return subObjs;
	}
	public void setSubObjs(List<Object2> subObjs) {
		this.subObjs = subObjs;
	}
}

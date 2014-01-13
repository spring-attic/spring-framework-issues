package com.pivotal.demos;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Object2 {

	@NotNull
	@Size(max=2)
	private String param1;

	@NotNull
	@Size(max=2)
	private String param2;

	@NotNull
	@Size(max=2)
	private String param3;

	@NotNull
	@Size(max=2)
	private String param4;

	@Override
	public String toString() {
		return "Object2 [param1=" + param1 + ", param2=" + param2 + ", param3="
				+ param3 + ", param4=" + param4 + "]";
	}

	public String getParam1() {
		return param1;
	}
	public void setParam1(String param1) {
		this.param1 = param1;
	}
	public String getParam2() {
		return param2;
	}
	public void setParam2(String param2) {
		this.param2 = param2;
	}
	public String getParam3() {
		return param3;
	}
	public void setParam3(String param3) {
		this.param3 = param3;
	}
	public String getParam4() {
		return param4;
	}
	public void setParam4(String param4) {
		this.param4 = param4;
	}

}

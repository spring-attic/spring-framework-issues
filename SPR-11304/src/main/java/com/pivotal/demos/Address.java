package com.pivotal.demos;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Address {

	@NotNull
	@Size(max=1)
	private String zip;

	@NotNull
	@Size(max=1)
	private String country;

	@Valid
	@Size(max=1)
	private List<Object1> objs = new ArrayList<Object1>();

	public Address() {
		this(100);
	}

	public Address(int numToCreate) {
		for (int i = 0; i < numToCreate; i++) {
			Object1 obj = new Object1();
			obj.setParam1("param1-" + i);
			objs.add(obj);
		}
	}

	@Override
	public String toString() {
		return "Address [zip=" + zip + ", country=" + country + "]";
	}

	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}

	public List<Object1> getObjs() {
		return objs;
	}

	public void setObjs(List<Object1> objs) {
		this.objs = objs;
	}

}

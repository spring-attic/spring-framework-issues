package com.test;

public class MyReciever {
	public MyInterface getInterface() {
		return null;
	}
	public void setInterface(MyInterface parent) {
		System.out.println("we got the interface! " + parent);
	}
	public void callMethod() {
		System.out.println("OK");
	}
}

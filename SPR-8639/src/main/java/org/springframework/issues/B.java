package org.springframework.issues;


public class B {

	private IC c;
	private ICWithAutoWired cWithAutoWired;
	
	public void setC( IC c ) {
		this.c = c;
	}
	
	public void setCWithAutoWired( ICWithAutoWired cWithAutoWired ) {
		this.cWithAutoWired = cWithAutoWired;
	}
}

package org.springframework.issues;


public class B {

	@SuppressWarnings("unused")
	private IC c;
	@SuppressWarnings("unused")
	private ICWithAutoWired cWithAutoWired;
	
	public void setC( IC c ) {
		this.c = c;
	}

	public void setCWithAutoWired( ICWithAutoWired cWithAutoWired ) {
		this.cWithAutoWired = cWithAutoWired;
	}
}

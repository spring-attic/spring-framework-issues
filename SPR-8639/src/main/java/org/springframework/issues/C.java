package org.springframework.issues;



public class C implements IC {

	private D d;
	
	
	public void setD( D d ) {
		this.d = d;
	}
	
	public D getD() {
		return d;
	}
}

package org.springframework.issues;

import org.springframework.beans.factory.annotation.Autowired;


public class CWithAutoWired implements ICWithAutoWired {

	@Autowired private D d;
	
	
	public D getD() {
		return d;
	}
}

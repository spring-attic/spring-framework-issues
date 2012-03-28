package org.springframework.issues;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public final class Bravo {
	
	@Autowired
	public Bravo(Charlie charlie) {
		
	}

}

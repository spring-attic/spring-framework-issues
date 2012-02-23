package org.springframework.issues;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

public final class OneConstructorAlpha extends Alpha {
	
	@Autowired(required=false)
	public OneConstructorAlpha(Bravo bravo, Set<Charlie> charlies, Set<Delta> deltas) {
		super(bravo, charlies, deltas);			
	}
}

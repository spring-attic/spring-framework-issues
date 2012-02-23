package org.springframework.issues;

import java.util.Collections;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

public final class TwoConstructorsAlpha extends Alpha {
	
	@Autowired(required=false)
	public TwoConstructorsAlpha(Bravo bravo) {
		this(bravo, Collections.<Charlie>emptySet(), Collections.<Delta>emptySet());	
	}
	
	@Autowired(required=false)
	public TwoConstructorsAlpha(Bravo bravo, Set<Charlie> charlies, Set<Delta> deltas) {
		super(bravo, charlies, deltas);			
	}	
}

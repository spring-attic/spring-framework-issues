package org.springframework.issues;

import java.util.Collections;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

public final class FourConstructorsAlpha extends Alpha {
	
	@Autowired(required=false)
	public FourConstructorsAlpha(Bravo bravo) {
		this(bravo, Collections.<Charlie>emptySet(), Collections.<Delta>emptySet());	
	}
	
	@Autowired(required=false)
	public FourConstructorsAlpha(Bravo bravo, Set<Charlie> charlies) {
		this(bravo, charlies, Collections.<Delta>emptySet());			
	}	
	
	@Autowired(required=false)
	public FourConstructorsAlpha(Set<Delta> deltas, Bravo bravo) {
		this(bravo, Collections.<Charlie>emptySet(), deltas);			
	}	
	
	@Autowired(required=false)
	public FourConstructorsAlpha(Bravo bravo, Set<Charlie> charlies, Set<Delta> deltas) {
		super(bravo, charlies, deltas);			
	}	
}

package org.springframework.issues;

import java.util.Set;

public abstract class Alpha {
	
	private final Bravo bravo;
	
	private final Set<Charlie> charlie;
	
	private final Set<Delta> delta;

	protected Alpha(Bravo bravo, Set<Charlie> charlie, Set<Delta> delta) {
		this.bravo = bravo;
		this.charlie = charlie;
		this.delta = delta;
	}

	public final Bravo getBravo() {
		return bravo;
	}

	public final Set<Charlie> getCharlie() {
		return charlie;
	}

	public final Set<Delta> getDelta() {
		return delta;
	}
}

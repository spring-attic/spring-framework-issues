package org.springframework.issues;

public class DummyAction {

	public boolean isZero(int param) {
		if (param > 0) {
			throw new IllegalArgumentException();
		}
		return true;
	}
}

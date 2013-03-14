package org.springframework.issues;

public class BaseTrolleyAwareController implements TrolleyAware {

	protected TrolleyImpl trolley;

	public TrolleyImpl getTrolley() {
		return trolley;
	}

	public void setTrolley(TrolleyImpl trolley) {
		this.trolley = trolley;
	}

}

package org.springframework.issues;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.annotation.Autowired;

public final class AlphaFactoryBean implements FactoryBean<Alpha> {
	
	private final Alpha alpha = new Alpha();
	
	@Autowired
	public AlphaFactoryBean(Bravo bravo) {
		
	}

	@Override
	public Alpha getObject() throws Exception {
		return this.alpha;
	}

	@Override
	public Class<?> getObjectType() {
		return Alpha.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}

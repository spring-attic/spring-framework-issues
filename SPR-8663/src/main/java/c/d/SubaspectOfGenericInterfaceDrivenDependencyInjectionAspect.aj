package c.d;

import my.ConfigObject;

import org.springframework.beans.factory.aspectj.GenericInterfaceDrivenDependencyInjectionAspect;

public aspect SubaspectOfGenericInterfaceDrivenDependencyInjectionAspect
		extends GenericInterfaceDrivenDependencyInjectionAspect<SomeInterface> {

	protected ConfigObject configObject;

	public void setConfigObject(ConfigObject configObject) {
		this.configObject = configObject;
	}

	public void configure(SomeInterface bean) {
		bean.setConfigObject(this.configObject);
	}
}

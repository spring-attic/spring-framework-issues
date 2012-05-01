package org.springframework.issues;

import org.springframework.context.annotation.Scope;

import javax.inject.Named;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Named
@Scope(SCOPE_PROTOTYPE)
public class ProviderClassImpl implements ProviderClass {

	public ProviderClassImpl(){

	}
}

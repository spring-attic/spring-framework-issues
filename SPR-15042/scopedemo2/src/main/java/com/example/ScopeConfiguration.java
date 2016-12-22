package com.example;

import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.target.CommonsPool2TargetSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;

@Configuration
public class ScopeConfiguration {

	@Bean
	@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
	public ProxyFactoryBean myObject() {
		ProxyFactoryBean pfb = new ProxyFactoryBean();
		pfb.setTargetSource(poolTargetSource());
		return pfb;
	}

	@Bean
	public CommonsPool2TargetSource poolTargetSource() {
		CommonsPool2TargetSource pool = new CommonsPool2TargetSource();
		pool.setMaxSize(3);
		pool.setTargetBeanName("myObjectTarget");
		return pool;
	}

	@Bean(name = "myObjectTarget")
	@Scope(scopeName="prototype")
	public Object myObjectTarget() {
		return new Object();
	}
}

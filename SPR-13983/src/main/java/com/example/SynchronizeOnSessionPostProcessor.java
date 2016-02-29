package com.example;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

@Component
public class SynchronizeOnSessionPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		// do synchronize each http request
		if (bean instanceof RequestMappingHandlerAdapter) {
			RequestMappingHandlerAdapter adapter = (RequestMappingHandlerAdapter) bean;
			adapter.setSynchronizeOnSession(true);
		}
		return bean;
	}

}
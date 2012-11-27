package org.springframework.issues;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.expression.StandardBeanExpressionResolver;


public class ExpressionResolverFactoryPostProcessor implements BeanFactoryPostProcessor {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory)
			throws BeansException {
		StandardBeanExpressionResolver expressionResolver = new StandardBeanExpressionResolver();
		expressionResolver.setExpressionPrefix("#$#{");
		beanFactory.setBeanExpressionResolver(expressionResolver);
	}
}

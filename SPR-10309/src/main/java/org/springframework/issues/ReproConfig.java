
package org.springframework.issues;

import org.springframework.aop.support.AbstractPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.validation.beanvalidation.MethodValidationPostProcessor;

@Configuration
@ComponentScan
@EnableAspectJAutoProxy
public class ReproConfig {

	/*
	 * @Bean public MethodValidationPostProcessor methodValidationPostProcessor() {
	 * MethodValidationPostProcessor methodValidationPostProcessor = new
	 * MethodValidationPostProcessor(); return methodValidationPostProcessor; }
	 */

	@Bean
	public OrderedMethodValidationPostProcessor orderedMethodValidationPostProcessor() {
		return new OrderedMethodValidationPostProcessor();
	}

	public class OrderedMethodValidationPostProcessor extends
			MethodValidationPostProcessor {

		private int adviceOrder = LOWEST_PRECEDENCE;

		@Override
		public void afterPropertiesSet() {
			super.afterPropertiesSet();
			AbstractPointcutAdvisor abstractPointcutAdvisor = (AbstractPointcutAdvisor) advisor;
			abstractPointcutAdvisor.setOrder(adviceOrder);
		}

		public void setAdviceOrder(int adviceOrder) {
			this.adviceOrder = adviceOrder;
		}
	}

}

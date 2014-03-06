package org.springframework.issues;

import org.junit.Test;
import org.springframework.expression.AccessException;
import org.springframework.expression.BeanResolver;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ReproTests {

	@Test
	public void repro() {
		StandardEvaluationContext context = new StandardEvaluationContext();
		context.setBeanResolver(new MyBeanResolver());
		Expression expr = new SpelExpressionParser().parseRaw("@dummyAction.isZero(@dummyBean.getCalls())");
		boolean value = expr.getValue(context, boolean.class);
		System.out.println(value);
	}

	static class MyBeanResolver implements BeanResolver {

		private final DummyAction dummyAction = new DummyAction();
		private final DummyBean dummyBean = new DummyBean();

		@Override
		public Object resolve(EvaluationContext context, String beanName) throws AccessException {

			if (beanName.equals("dummyAction")) {
				return dummyAction;
			} else if (beanName.equals("dummyBean")) {
				return dummyBean;
			}
			return null;
		}
	}
}

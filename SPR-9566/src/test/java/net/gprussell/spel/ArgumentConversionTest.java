package net.gprussell.spel;

import static org.junit.Assert.assertSame;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class ArgumentConversionTest {

	@Autowired
	private BeanFactory beanFactory;

	@Test
	public void testBytesNotCopied() throws Exception {
		Expression expression = new SpelExpressionParser().parseExpression("@service.handleBytes(#root)");
		byte[] bytes = new byte[100];
		StandardEvaluationContext evaluationContext = new StandardEvaluationContext(bytes);
		evaluationContext.setBeanResolver(new BeanFactoryResolver(this.beanFactory));
		byte[] outBytes = expression.getValue(evaluationContext, byte[].class);
		assertSame(bytes, outBytes);
	}

}

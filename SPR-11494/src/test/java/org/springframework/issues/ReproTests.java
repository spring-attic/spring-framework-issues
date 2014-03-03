package org.springframework.issues;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 */
public class ReproTests {

	@Test
	public void spr11494() { // Expected to fail
		new SpelExpressionParser().parseExpression("T(java.util.Arrays).asList('a','b')");
	}
}

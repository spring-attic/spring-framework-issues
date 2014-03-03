package org.springframework.issues;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 */
public class ReproTests {

	@Test
	public void spr11494() {
		Expression exp = new SpelExpressionParser().parseExpression("T(java.util.Arrays).asList('a','b')");
		List<String> list = (List<String>) exp.getValue();
		assertThat(list.size(), is(2));
	}
}

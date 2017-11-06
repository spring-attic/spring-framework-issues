package org.springframework.issues;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.Map;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ReproTests {

	@Test
	public void repro() {
		try (AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext()) {
			ctx.register(ConfigClass.class);
			ctx.refresh();
			Map<String, IDummy> beans = ctx.getBeansOfType(IDummy.class);
			assertNotNull(beans.get("bean1"));
			assertNotNull(beans.get("bean2"));
			assertNotNull(beans.get("bean3"));
			assertNull(beans.get("bean4"));

		}

	}

}

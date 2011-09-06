package org.springframework.issues;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.aop.Advisor;
import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ReproTests {

	@Test
	public void repro() throws Exception {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load(getClass(), "ReproTests-context.xml");
		ctx.refresh();

		C c = ctx.getBean(C.class);
		MyInterceptor interceptor = ctx.getBean(MyInterceptor.class);

		assertThat("expected c to be a proxy", AopUtils.isAopProxy(c), is(true));
		Advisor[] advisors = ((Advised)c).getAdvisors();
		assertTrue("interceptor was not added to c's set of advisors",
				advisors.length == 1 && advisors[0].getAdvice() == interceptor);
	}
}

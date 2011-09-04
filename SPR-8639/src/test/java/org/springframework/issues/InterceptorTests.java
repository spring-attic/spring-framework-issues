package org.springframework.issues;

import static junit.framework.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"app-test-context.xml"})
public class InterceptorTests {

	@Autowired
	private IC c;

	@Autowired
	@Qualifier("c-with-autowired")
	private ICWithAutoWired cWithAutoWired;

	@Autowired
	private AnyInterceptor anyInterceptor;

	@Test
	public void repro() throws Exception {
		c.getD();
		assertEquals( 1, anyInterceptor.getInvokedBy().size() );

		cWithAutoWired.getD();
		//failed, anyInterceptor invoked only once
		assertEquals( 2, anyInterceptor.getInvokedBy().size() );
	}
}

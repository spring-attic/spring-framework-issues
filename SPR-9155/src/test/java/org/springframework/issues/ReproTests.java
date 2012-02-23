package org.springframework.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ReproTests {

	@Test
	public void singleConstructorNoCharlieNoDelta() {
		Alpha alpha = createAndRefreshApplicationContext("one-constructor");
		assertNotNull(alpha.getBravo());
	}
	
	@Test
	public void singleConstructorJustCharlie() {
		Alpha alpha = createAndRefreshApplicationContext("one-constructor", "charlie");
		assertJustCharlie(alpha);
	}
	
	@Test
	public void singleConstructorJustDelta() {
		Alpha alpha = createAndRefreshApplicationContext("one-constructor", "delta");
		assertJustDelta(alpha);
	}
	
	@Test
	public void singleConstructorCharlieAndDelta() {
		Alpha alpha = createAndRefreshApplicationContext("one-constructor", "charlie", "delta");
		assertCharlieAndDelta(alpha);
	}
	
	@Test
	public void twoConstructorsNoCharlieNoDelta() {
		Alpha alpha = createAndRefreshApplicationContext("two-constructors");
		assertNotNull(alpha.getBravo());
	}

	@Test
	public void twoConstructorsJustCharlie() {
		Alpha alpha = createAndRefreshApplicationContext("two-constructors", "charlie");			
		assertJustCharlie(alpha);
	}
	
	@Test
	public void twoConstructorsJustDelta() {
		Alpha alpha = createAndRefreshApplicationContext("two-constructors", "delta");		
		assertJustDelta(alpha);
	}

	@Test
	public void twoConstructorsCharlieAndDelta() {
		Alpha alpha = createAndRefreshApplicationContext("two-constructors", "charlie", "delta");		
		assertCharlieAndDelta(alpha);
	}
	
	@Test
	public void fourConstructorsNoCharlieNoDelta() {
		Alpha alpha = createAndRefreshApplicationContext("four-constructors");
		assertNotNull(alpha.getBravo());
	}

	@Test
	public void fourConstructorsJustCharlie() {
		Alpha alpha = createAndRefreshApplicationContext("four-constructors", "charlie");			
		assertJustCharlie(alpha);
	}
	
	@Test
	public void fourConstructorsJustDelta() {
		Alpha alpha = createAndRefreshApplicationContext("four-constructors", "delta");		
		assertJustDelta(alpha);
	}

	@Test
	public void fourConstructorsCharlieAndDelta() {
		Alpha alpha = createAndRefreshApplicationContext("four-constructors", "charlie", "delta");		
		assertCharlieAndDelta(alpha);
	}
	
	private void assertJustDelta(Alpha alpha) {
		assertNotNull(alpha.getBravo());
		assertNotNull(alpha.getDelta());
		assertEquals(1, alpha.getDelta().size());
	}
	
	private void assertJustCharlie(Alpha alpha) {
		assertNotNull(alpha.getBravo());
		assertNotNull(alpha.getCharlie());
		assertEquals(1, alpha.getCharlie().size());
	}

	private void assertCharlieAndDelta(Alpha alpha) {
		assertJustCharlie(alpha);
		assertNotNull(alpha.getDelta());
		assertEquals(1, alpha.getDelta().size());
	}
	
	private Alpha createAndRefreshApplicationContext(String... profiles) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment().setActiveProfiles(profiles);
		ctx.load("classpath:org/springframework/issues/ReproTests-context.xml");
		ctx.refresh();
		
		return ctx.getBean(Alpha.class);		
	}
}

package com.example;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/applicationContext.xml" })
public class ComponentScanTest {

	@Autowired
	private UsesAnnotation underTest;

	/** Tests that the dependency is injected into the abstract base class. */
	@Test
	public void testDependencyInjected() {
		// this test passes when compiled with Java 5 but fails when compiled
		// with Java 6
		assertNotNull(underTest);
	}

}

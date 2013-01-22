package org.springframework.issues;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
public class PropertyPlaceholderDefaultValueTest {

	@Value("${prop1}")
	private String prop1Value;

	@Value("${prop2}")
	private String prop2Value;

	@Value("${prop1:value1default}")
	private String prop1ValueWithDefault;

	@Value("${prop2:value2default}")
	private String prop2ValueWithDefault;

	@Test
	public void test() {
		assertEquals(prop1Value, prop1ValueWithDefault);
		assertEquals(prop2Value, prop2ValueWithDefault); // Fails here, default value has been used instead of the one from property placeholder
	}

}

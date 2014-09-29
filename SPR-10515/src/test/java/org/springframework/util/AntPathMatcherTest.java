package org.springframework.util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.util.AntPathMatcher;


public class AntPathMatcherTest {

	@Test
	public void extractPathWithinPattern_SPR_10515_test() {
		// Given
		String pattern = "**/something";
		String path = "/one/two/three/something";

		// When
		String pathWithinPattern = new AntPathMatcher().extractPathWithinPattern(pattern, path);

		// Then
		assertEquals("/one/two/three/something", pathWithinPattern);
	}

}

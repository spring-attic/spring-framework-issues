package org.springframework.issues;

import org.springframework.format.FormatterRegistrar;
import org.springframework.format.FormatterRegistry;

public class TestFormatterRegistrar implements FormatterRegistrar {

	@Override
	public void registerFormatters(FormatterRegistry registry) {
		registry.removeConvertible(String.class, Object[].class);
	}

}

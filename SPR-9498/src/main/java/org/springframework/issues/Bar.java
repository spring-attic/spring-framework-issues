package org.springframework.issues;

import java.util.Arrays;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class Bar {

	private final MultiValueMap<String,String> parameters = new LinkedMultiValueMap<String, String>();
	
	public Bar() {
	}

	public Bar(Map<String,String[]> parameters) {
		if (parameters!=null) {
			for (Entry<String,String[]> entry : parameters.entrySet()) {
				this.parameters.put(entry.getKey(), Arrays.asList(entry.getValue()));
			}
		}
	}

	public MultiValueMap<String, String> getParameters() {
		return parameters;
	}
}

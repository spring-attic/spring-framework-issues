package net.gprussell.spel;

import org.springframework.stereotype.Component;


/**
 * {@link Service} with hard-coded input data.
 */
@Component
public class ExampleService implements Service {
	
	public String getMessage() {
		return "Hello world!";	
	}

	public byte[] handleBytes(byte[] bytes) {
		return bytes;
	}

}

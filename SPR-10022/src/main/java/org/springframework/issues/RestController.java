package org.springframework.issues;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.commons.lang.exception.ExceptionUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Controller to depict erratic/incomplete behavior of MessageConverter mappings.
 * Controller has been tested on:
 * - Windows XP SP3
 * - Tomcat 6.0.35
 * - Firefox 17
 * - Firebug 1.10.6
 * 
 * Auto-configured Jackson message converter returns UTF-8 encoding by default.
 */
@Controller
@RequestMapping("/rest")
public class RestController {

	/**
	 * Explicitly sets the output content type w/o charset value. The charset
	 * value from the message converter is not added. Characters are
	 * not properly displayed by Firebug. 
	 */
	@RequestMapping(value = "/explicit-partial", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Map<String, String>> explicitPartial() {
		return getMessage();
	}

	/**
	 * Explicitly setting content type AND charset value. Works as expected just
	 * because Jackson uses UTF-8 as default. See next example.
	 */
	@RequestMapping(value = "/explicit-complete-utf8", method = RequestMethod.GET, produces = "application/json;charset=utf8")
	public ResponseEntity<Map<String, String>> explicitCompleteUtf8() {
		return getMessage();
	}

	/**
	 * Sets both again explicitly. Client receives notification about charset and
	 * converts bytes as indicated. Pity that Jackson still defaults to UTF-8
	 * and does not get notified about that. Though it makes absolutely no sense
	 * using anything else but UTF-8 but if we have such an option it should
	 * simply work.
	 */
	@RequestMapping(value = "/explicit-complete-latin1", method = RequestMethod.GET, produces = "application/json;charset=latin1")
	public ResponseEntity<Map<String, String>> explicitCompleteLatin1() {
		return getMessage();
	}

	/**
	 * Implicit best match. Charset from Jackson message converter is set.
	 */
	@RequestMapping(value = "/implicit", method = RequestMethod.GET)
	public ResponseEntity<Map<String, String>> implicit() {
		return getMessage();
	}

	/**
	 * Uses settings of {@link #implicitException()}and {@link #explicitPartialException()}.
	 * Same issue, same outcome. 
	 */
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<Map<String, String>> handleRuntimeException(RuntimeException e) {
		return getMessage(e);
	}

	/**
	 * @see #implicit()
	 */
	@RequestMapping(value = "/implicit-exception", method = RequestMethod.GET)
	public ResponseEntity<Map<String, String>> implicitException() {
		throw new RuntimeException("Yöü did nöt €xp€ct thät!");
	}

	/**
	 * @see #explicitPartial()
	 */
	@RequestMapping(value = "/explicit-partial-exception", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<Map<String, String>> explicitPartialException() {
		throw new RuntimeException("Yöü did nöt €xp€ct thät!");
	}
	
	// One could now further duplicate all explicit methods and throw RuntimeException

	private ResponseEntity<Map<String, String>> getMessage() {
		return getMessage(null);
	}
	
	private ResponseEntity<Map<String, String>> getMessage(RuntimeException e) {

		Map<String, String> message = new LinkedHashMap<String, String>();

		message.put("reason", "invalid_parameter");
		message.put("message", "Der übergebe Wert 'foo' ist ungültig");
		if (e != null)
			message.put("exception", ExceptionUtils.getMessage(e));

		return new ResponseEntity<Map<String, String>>(message,
				HttpStatus.BAD_REQUEST);
	}

}

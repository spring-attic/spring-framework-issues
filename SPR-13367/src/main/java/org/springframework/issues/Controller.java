package org.springframework.issues;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.simp.annotation.SubscribeMapping;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class Controller {

	@SubscribeMapping("/topic/{subject}")
	public Object snapshot(@DestinationVariable String subject) {
		return null;
	}

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@PreAuthorize("hasRole('ROLE_USER')")
	public void add(@RequestBody Object obj) {
	}

}
package org.springframework.issues;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@RestController
@Transactional
public interface Controller1Operations {

	@RequestMapping("/test")
	Object test(@RequestParam("msg") String msg);

}

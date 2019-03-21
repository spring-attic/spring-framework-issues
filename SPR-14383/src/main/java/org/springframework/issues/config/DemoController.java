/*
 * Copyright 2002-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.issues.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.HEAD;

@Controller
@RequestMapping("/abcd/{myID}/stuff")
public class DemoController {

	@ResponseBody
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@RequestMapping(value = "/*", method = HEAD)
	public void checkExists(@PathVariable String myID) {
		System.out.println("checkExists...");
	}

	@ResponseBody
	@RequestMapping(value = "/*", method = GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity get(@PathVariable String myID) {
		System.out.println("get...");
		return ResponseEntity.ok().build();
	}

}

/*
 * Copyright 2002-2014 the original author or authors.
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

package org.springframework.issues;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TestController {


	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String handleGet(ModelMap model) {
		model.addAttribute("command", new TestEntity());
		return null;
	}

	@RequestMapping(value = "/test", method = RequestMethod.POST)
	public String handlePost(@ModelAttribute("command") TestEntity testEntity, BindingResult result) {
		result.rejectValue("name", null, "lat=<img onerror=\"alert(String.fromCharCode(120,115,115))\" src=\"#\">");
		return "test";
	}

}

/*
 * Copyright 2002-2015 the original author or authors.
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
package jira.transactional;

import java.io.IOException;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/test")
@Transactional
public class TestController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	@Inject
	private MyValidator myValidator;

	@InitBinder("myObj")
	private void initBinder(WebDataBinder binder) {
		logger.info("myValidator = {}", myValidator);
		binder.initDirectFieldAccess();
		binder.setValidator(myValidator);
	}

	@RequestMapping(value = "/doPost", method = RequestMethod.POST)
	public String doPost(@Valid MyObj myObj, BindingResult br) throws IOException {
		logger.info("myObj = {} , bindingResult = {}", myObj, br);
		if(br.hasErrors()) {
			return "error";
		}
		return "redirect:/test/form";
	}
}

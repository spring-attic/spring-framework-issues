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
package jira.working;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

/**
 * @author Rob Winch
 *
 */
@Component
public class MyValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz != null && clazz.isAssignableFrom(MyObj.class);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MyObj obj = (MyObj) target;

		if(!obj.isValid()) {
			errors.reject("oops","oops");
		}
	}
}
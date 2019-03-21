/*
 * Copyright 2002-2012 the original author or authors.
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

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This controller demonstrates raising a {@link ValidationException}, which in
 * turn is annotated with {@code @ResponseStatus} that specifies an error code
 * and an error message for the response.
 *
 * <p>Whenever {@link HttpServletResponse#sendError(int, String)} is used (or the
 * response is set to an error status code), servlet containers may render an HTML
 * error page. This behavior can be customized and some alternative content can
 * be returned instead. See web.xml and {@link ErrorController}.
 *
 */
@Controller
public class ExampleController {

	@RequestMapping(value="/example", method=RequestMethod.GET)
	public void handle() throws Exception {
		throw new ValidationException();
	}

}

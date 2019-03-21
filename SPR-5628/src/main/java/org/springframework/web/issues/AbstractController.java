/*
 * Copyright 2002-2011 the original author or authors.
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

package org.springframework.web.issues;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public abstract class AbstractController {

	@RequestMapping(value="/requestParam")
	@ResponseBody
	public String requestParam(@RequestParam(required=false) String param) {
		return "param=" + param;
	}

	@RequestMapping(value="/requestBody")
	@ResponseBody
	public String requestBody(@RequestBody MultiValueMap<String, String> params) {
		return "params=" + params;
	}

	@RequestMapping(value="/requestParamAndInputStream")
	@ResponseBody
	public String requestParamAndInputStream(@RequestParam(required=false) String param, 
											 InputStream input) throws IOException {
		String content = FileCopyUtils.copyToString(new InputStreamReader(input, Charset.forName("UTF-8")));
		return "param=" + param + ", content=[" + content + "]";
	}

}

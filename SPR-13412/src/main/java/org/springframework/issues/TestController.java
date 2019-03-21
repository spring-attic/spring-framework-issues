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
package org.springframework.issues;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.async.DeferredResult;

@Controller
public class TestController {

	@RequestMapping(value = "/getAsync", method = RequestMethod.GET)
	@ResponseBody
	public DeferredResult<String> getAsync() {
		final DeferredResult<String> res = new DeferredResult<String>();
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(5000);
					res.setResult("Test string");
				} catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		}).start();
		return res;
	}

}

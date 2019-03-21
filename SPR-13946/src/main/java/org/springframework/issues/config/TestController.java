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

import java.io.OutputStream;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

@Controller
public class TestController {

	@RequestMapping("/emitter")
	ResponseBodyEmitter provision() throws Exception {

		final ResponseBodyEmitter emitter = new ResponseBodyEmitter();
		new Thread(() -> {
			String[] chunks = { "chunk1", "chunk2", "chunk3" };
			for (String chunk : chunks) {
				try {
					emitter.send(chunk, MediaType.TEXT_PLAIN);
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			emitter.complete();
		}).start();
		return emitter;
	}

	@RequestMapping("/out")
	void provision(HttpServletResponse response) throws Exception {

		String[] chunks = { "chunk1", "chunk2", "chunk3" };
		response.setContentType("text/html; charset=UTF-8");
		OutputStream os = response.getOutputStream();

		for (String chunk : chunks) {
			os.write(chunk.getBytes());
			os.flush();
			response.flushBuffer();
			System.out.println("chunk sent!");
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


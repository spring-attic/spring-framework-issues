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

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.AsyncContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// Demonstrates Tomcat issue:
// https://bz.apache.org/bugzilla/show_bug.cgi?id=58457

@Controller
public class RawServletAsyncController extends HttpServlet {

	private final AtomicInteger index = new AtomicInteger();


	@RequestMapping(path = "/async", method = RequestMethod.GET)
	public void handle(HttpServletRequest request, ServletOutputStream os) throws Exception {

		System.out.println("Starting async request");
		AsyncContext asyncContext = request.startAsync();
		asyncContext.setTimeout(5000);

		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
			try {
				int indexValue = index.getAndIncrement();
				System.out.println(Thread.currentThread() + " index: " + indexValue);
				os.println(Thread.currentThread() + " index: " + indexValue);
				os.flush();
			}
			catch (Throwable e) {
				System.out.println("Exception: " + e.getMessage());
			}

		} , 1000, 1000, TimeUnit.MILLISECONDS);
	}

}

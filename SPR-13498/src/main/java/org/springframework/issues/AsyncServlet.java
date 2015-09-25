/*
 * Copyright 2002-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.issues;

import java.io.IOException;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AsyncServlet extends HttpServlet {

	private final AtomicInteger index = new AtomicInteger();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("Starting async request");
		AsyncContext asyncContext = req.startAsync(req, resp);
		asyncContext.setTimeout(5000);

		Executors.newScheduledThreadPool(1).scheduleAtFixedRate(() -> {
			try {
				int indexValue = index.getAndIncrement();
				System.out.println(Thread.currentThread() + " index: " + indexValue);
				resp.getOutputStream().println(Thread.currentThread() + " index: " + indexValue);
				resp.getOutputStream().flush();
			}
			catch (Throwable e) {
				System.out.println("Exception: " + e.getMessage());
			}

		} , 1000, 1000, TimeUnit.MILLISECONDS);

	}
}

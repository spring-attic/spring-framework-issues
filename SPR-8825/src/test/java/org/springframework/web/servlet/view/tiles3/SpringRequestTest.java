/*
 * Copyright 2002-2012 the original author or authors.
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
package org.springframework.web.servlet.view.tiles3;

import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import java.util.Locale;

import org.apache.tiles.request.DispatchRequest;
import org.junit.Before;
import org.junit.Test;

public class SpringRequestTest {
	private DispatchRequest request;
	private SpringRequest testTarget;

	@Before
	public void setUp() {
		request = createMock(DispatchRequest.class);
		testTarget = new SpringRequest(request, Locale.ITALY);
	}

	@Test
	public void testGetRequestLocale() {
		// do not expect(request.getRequestLocale()).andReturn(Locale.ENGLISH);
		replay(request);
		assertEquals(Locale.ITALY, testTarget.getRequestLocale());
		verify(request);
	}
}

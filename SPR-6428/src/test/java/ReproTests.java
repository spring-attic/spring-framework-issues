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

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.core.env.MapPropertySource;

/**
 * Unit tests demonstrating the failure reported by SPR-6428, and the workaround using
 * Spring's Environment and PropertySource APIs that fixes it.
 *
 * @author Chris Beams
 */
public class ReproTests {

	/**
	 * Test will fail as two PropertyPlaceholderConfigurer beans are defined, with one
	 * depending on the other for placeholder resolution.  This is a lifecycle issue with
	 * the way BeanFactoryPostProcessors are processed.  See {@link #workaround()} below
	 * for a solution to this.
	 */
	@Test
	public void repro() {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("ReproTests-repro.xml");
		ctx.refresh();
	}

	/**
	 * Work around the lifecycle issues above by introducing a PropertySource containing
	 * the value for the "resourceDirPlaceHolder"
	 */
	@Test
	public void workaround() {
		Map<String,Object> localProps = new HashMap<String,Object>();
		localProps.put("resourceDirPlaceHolder", "myResourceDir");

		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.getEnvironment()
			.getPropertySources()
				.addFirst(new MapPropertySource("localProps", localProps));
		ctx.load("ReproTests-workaround.xml");
		ctx.refresh();
	}

}

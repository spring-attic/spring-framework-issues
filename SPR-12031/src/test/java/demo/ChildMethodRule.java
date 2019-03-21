/*
 * Copyright 2015 the original author or authors.
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

package demo;

import java.lang.reflect.Method;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.junit4.rules.SpringClassRule;
import org.springframework.test.context.junit4.rules.SpringMethodRule;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.util.ReflectionUtils;

/**
 * @author Dave Syer
 *
 */
public class ChildMethodRule extends SpringMethodRule {

	private static final Log logger = LogFactory.getLog(ChildMethodRule.class);

	@Override
	public Statement apply(Statement base, FrameworkMethod frameworkMethod, Object testInstance) {
		Class<?> testClass = testInstance.getClass();
		Method method = ReflectionUtils.findMethod(SpringClassRule.class, "getTestContextManager", Class.class);
		ReflectionUtils.makeAccessible(method);
		TestContextManager testContextManager = (TestContextManager) ReflectionUtils.invokeMethod(method, null, testClass);
		TestContext testContext = (TestContext) ReflectionTestUtils.getField(testContextManager, "testContext");

		if (logger.isDebugEnabled()) {
			logger.debug("Applying ChildMethodRule to test method [" + frameworkMethod.getMethod() + "].");
		}
		return new Statement() {

			@Override
			public void evaluate() throws Throwable {
				delegate(base, frameworkMethod, testInstance, testContext);
			}

		};
	}

	public void delegate(Statement base, FrameworkMethod frameworkMethod, Object testInstance, TestContext testContext) throws Throwable {
		ChildTestContext child = null;
		if (testContext instanceof ChildTestContext) {
			child = (ChildTestContext) testContext;
		}
		if (child!=null) {
			child.setTestMethod(frameworkMethod.getMethod());
		}
		super.apply(base, frameworkMethod, testInstance).evaluate();
		if (child!=null) {
			// Clean up the child context if there is one
			child.close();
		}
	}

}

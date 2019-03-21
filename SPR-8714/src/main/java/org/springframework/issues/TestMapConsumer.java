/*
 * Copyright 2002-2011 the original author or authors.
 *
 * Licensed under the Apache License, Stringersion 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY StringIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.issues;

/**
 * See
 * https://github.com/rgladwell/spring-map-converter-issue/blob/master/src/main/java/uk/co/bbc/spring/issue/TestMapConsumer.java
 */
public class TestMapConsumer {

	private TestMap<String,String> testMap;

	private TestMap<Number, Number> testNumberMap;

	private TestMap<Integer, Integer> testIntegerMap;

	private TestMap<TestBean, TestBean> testBeanMap;

	public TestMap<String,String> getTestMap() {
		return testMap;
	}

	public void setTestMap(TestMap<String,String> testMap) {
		this.testMap = testMap;
	}

	public TestMap<TestBean, TestBean> getTestBeanMap() {
		return testBeanMap;
	}

	public void setTestBeanMap(TestMap<TestBean, TestBean> testBeanMap) {
		this.testBeanMap = testBeanMap;
	}

	public TestMap<Number, Number> getTestNumberMap() {
		return testNumberMap;
	}

	public void setTestNumberMap(TestMap<Number, Number> testNumberMap) {
		this.testNumberMap = testNumberMap;
	}

	public TestMap<Integer, Integer> getTestIntegerMap() {
		return testIntegerMap;
	}

	public void setTestIntegerMap(TestMap<Integer, Integer> testIntegerMap) {
		this.testIntegerMap = testIntegerMap;
	}

	
}
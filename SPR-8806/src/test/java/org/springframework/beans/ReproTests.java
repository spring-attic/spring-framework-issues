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

package org.springframework.beans;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;

import org.junit.Test;
import org.springframework.beans.LawLibrary;


public class ReproTests {

	@Test
	public void reproSpr8806() throws IntrospectionException {
		BeanInfo bi = Introspector.getBeanInfo(LawLibrary.class);
		new ExtendedBeanInfo(bi); // throws
	}

}

interface Book { }

interface TextBook extends Book { }

interface LawBook extends TextBook { }

interface BookOperations {
	Book getBook();
	void setBook(Book book);
}

interface TextBookOperations extends BookOperations {
	TextBook getBook();
}

abstract class Library {
	public Book getBook() { return null; }
	public void setBook(Book book) { }
}

class LawLibrary extends Library implements TextBookOperations {
	public LawBook getBook() { return null; }
}

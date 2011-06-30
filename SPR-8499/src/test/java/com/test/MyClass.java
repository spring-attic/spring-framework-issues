package com.test;

import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MyClass extends AbstractSet<String> implements MyInterface {

	private Set<String> set = new HashSet<String>();

	public MyClass() {
		set.add("one");
		set.add("two");
		set.add("three");
	}

	@Override
	public Iterator<String> iterator() {
		return set.iterator();
	}

	@Override
	public int size() {
		return set.size();
	}

}

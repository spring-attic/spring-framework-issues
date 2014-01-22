package org.springframework.issues;

public interface TestEntityDAO {
	public int getCount(String name);

	public int incrementCount(String name);
}

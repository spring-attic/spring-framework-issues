package org.springframework.issues.model;

public class Animal
{
	private final String name;

	public Animal(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}
}

package org.springframework.issues.model;

public class Cat extends Animal
{
	private final int whiskers;

	public Cat(String name, int whiskers)
	{
		super(name);
		this.whiskers = whiskers;
	}

	public int getWhiskers()
	{
		return whiskers;
	}
}

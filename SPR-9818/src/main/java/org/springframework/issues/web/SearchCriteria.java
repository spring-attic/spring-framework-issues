package org.springframework.issues.web;

public class SearchCriteria {

	private int age;

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "SearchCriteria [age=" + age + "]";
	}

}

package org.springframework.issues.config;

public class Form {

	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Form{" +
				"id=" + id +
				'}';
	}
}

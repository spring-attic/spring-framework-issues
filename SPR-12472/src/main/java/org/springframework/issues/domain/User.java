package org.springframework.issues.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	@Override
	public boolean equals(Object user) {
		if (user instanceof Long) { return this.id == user; }
		else if (user instanceof String) { return Long.toString(this.id).equals(user); }
		else if (user instanceof User) { return this.id == (((User) user).getId()); }
		else return false;
	}

	@Override
	public String toString() {
		return String.format("User[id=%d, name='%s']", id, name);
	}

	public static User valueOf(String id) {
		User user = new User();
		user.setId(Long.valueOf(id));
		return user;
	}
}

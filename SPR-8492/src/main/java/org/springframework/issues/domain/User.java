package org.springframework.issues.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "USERS")
@NamedQueries(@NamedQuery(name = User.QUERY_ALL_USERS, query = "SELECT u FROM org.springframework.issues.domain.User u"))
public class User {

	public static final String QUERY_ALL_USERS = "User.getAllUsers";

	@Id
	@Column(name = "USR_ID")
	private long id;

	@Column(name = "USR_NAME")
	private String name;

	@Column(name = "USR_CITY")
	private String city;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}

package org.springframework.issues.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "managers")
public final class Manager implements Serializable {
	@Id
	@Column(name = "user_id", length = 15, nullable = false)
	@Size(max = 15)
	private String userId;

	@Column(name = "name", length = 255, nullable = false)
	@Size(max = 255)
	private String name;

	@Column(name = "email", length = 255, nullable = false)
	@Size(max = 255)
	private String email;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
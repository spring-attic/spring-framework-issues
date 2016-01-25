package org.springframework.issues.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.issues.event.PersonUpdatedEvent;

@Entity
@Table(name = "persons")
@Configurable
public final class Person implements Serializable {

	// injected by AspectJ
	@Autowired
	private transient ApplicationEventPublisher eventPublisher;

	@PostUpdate
	void postUpdate() {
		// the only way I could find to make sure this event is triggered when the entity really has 'dirty' properties
		eventPublisher.publishEvent(new PersonUpdatedEvent(this));
	}

	@Id
	@Column(name = "user_id", length = 15, nullable = false)
	@Size(max = 15)
	private String userId;

	@Column(name = "email", length = 255, nullable = false)
	@Size(max = 255)
	private String email;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "manager_id", nullable = true)
	private Manager manager;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
}
package org.springframework.issues.event;

import org.springframework.context.ApplicationEvent;
import org.springframework.issues.entity.Person;

public class PersonUpdatedEvent extends ApplicationEvent {

	public PersonUpdatedEvent(Person instance) {
		super(instance);
	}

	public Person getPerson() {
		return (Person) super.getSource();
	}
}
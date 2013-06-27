package org.springframework.issues;

import java.io.Serializable;

public class SoftwareVersionVO implements Serializable {
	private int id;
	private String name;	
	private boolean participation;
	private boolean active;

	public SoftwareVersionVO() {
		super();
	}

	public SoftwareVersionVO (int id, String name, boolean active,boolean participation) {
		setId(id);
		setName(name);		
		setParticipation(participation);
		setActive(active);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isParticipation() {
		return participation;
	}

	public void setParticipation(boolean participation) {
		this.participation = participation;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}

package org.chare.service;

import org.chare.entity.User;

public class UserPreferences {

	public User user;

	public UserPreferences() {
		this(new User());
	}

	public UserPreferences(User user) {
		this.user = user;
	}

}

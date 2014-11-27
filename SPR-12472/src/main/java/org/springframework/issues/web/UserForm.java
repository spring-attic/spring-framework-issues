package org.springframework.issues.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.issues.domain.User;

public class UserForm {

	private List<User> selectedUsers;

	public List<User> getSelectedUsers() {
		return selectedUsers;
	}

	public List<Long> getSelectedUsersIds() {
		List<Long> ids = new ArrayList<Long>();
		for(User user : this.selectedUsers) {
			ids.add(user.getId());
		}
		return ids;
	}

	public void setSelectedUsers(List<User> selectedUsers) {
		this.selectedUsers = selectedUsers;
	}
}

package org.springframework.issues.service;

import java.util.List;

import org.springframework.issues.domain.User;

public interface UserService {

	public void saveUser(User user);

	public List<String> getNames();

}

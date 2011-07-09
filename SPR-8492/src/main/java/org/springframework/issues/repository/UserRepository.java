package org.springframework.issues.repository;

import java.util.List;

import org.springframework.issues.domain.User;

public interface UserRepository {

	public void addUser(User user);

	public User getUser(long id);

	public void updateUser(User user);

	public List<User> getAllUsers();

}

package org.springframework.issues.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.issues.domain.User;
import org.springframework.issues.repository.UserRepository;
import org.springframework.issues.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class UserServiceImpl implements UserService {

	private UserRepository userRepository;

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void saveUser(User user) {
		if (userRepository.getUser(user.getId()) == null) {
			userRepository.addUser(user);
		} else {
			userRepository.updateUser(user);
		}
	}

	public List<String> getNames() {
		List<User> userList = userRepository.getAllUsers();
		List<String> nameList = new ArrayList<String>();
		for (User user : userList) {
			nameList.add(user.getName());
		}
		return nameList;
	}

}

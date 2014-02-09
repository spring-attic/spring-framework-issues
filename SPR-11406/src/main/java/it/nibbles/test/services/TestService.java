package it.nibbles.test.services;

import it.nibbles.test.dao.UserRepository;
import it.nibbles.test.exceptions.UserNotFoundException;
import it.nibbles.test.objs.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TestService {

    @Autowired
    private UserRepository userRepository;

    public User findUser(String name) {
        User user = userRepository.findByName(name);
        if (user == null) {
            throw new UserNotFoundException(name);
        }
        return user;
    }

    public void save(User user) {
        userRepository.save(user);
    }
}

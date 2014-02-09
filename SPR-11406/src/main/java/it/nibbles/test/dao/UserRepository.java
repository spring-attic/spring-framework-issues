package it.nibbles.test.dao;

import it.nibbles.test.objs.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Alessandro Polverini
 */
public interface UserRepository extends JpaRepository<User, Integer> {

    @Transactional(readOnly = true)
    User findByName(String name);
}

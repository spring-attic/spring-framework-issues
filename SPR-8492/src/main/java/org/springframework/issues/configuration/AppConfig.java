package org.springframework.issues.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.issues.repository.UserRepository;
import org.springframework.issues.repository.impl.HibernateUserRepository;
import org.springframework.issues.service.UserService;
import org.springframework.issues.service.impl.UserServiceImpl;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@Import(DataConfig.class)
@Configuration
public class AppConfig {

	@Autowired
	DataConfig dataConfig;

	@Bean
	public UserRepository userRepository() throws Exception {
		return new HibernateUserRepository(dataConfig.sessionFactory());
	}

	@Bean
	public UserService userService() throws Exception {
		UserServiceImpl userService = new UserServiceImpl();
		userService.setUserRepository(userRepository());
		return userService;
	}

}

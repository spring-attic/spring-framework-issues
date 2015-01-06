package org.springframework.issues.web;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.issues.domain.User;
import org.springframework.issues.domain.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController implements InitializingBean {

	private final UserRepository repository;

	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	public UserController(UserRepository repository) {
		this.repository = repository;
	}

	@RequestMapping("/user/{id}")
	@ResponseBody
	public String showuser(@PathVariable("id") User user) {
		return user.toString();
	}

	@RequestMapping("/issue")
	public String issue(Model model) {

		fillModel(model);
		return "issue";
	}

	@RequestMapping("/ids")
	public String ids(Model model) {

		fillModel(model);
		return "ids";
	}

	@RequestMapping("/select")
	public String select(Model model) {

		fillModel(model);
		return "select";
	}

	@RequestMapping("/comparator")
	public String comparator(Model model) {

		fillModel(model);
		return "comparator";
	}

	private void fillModel(Model model) {
		model.addAttribute("userList", repository.findAll());
		logger.info("fetched the list of all users");

		UserForm form = new UserForm() ;
		form.setSelectedUsers(Arrays.asList(repository.findOne(9L), repository.findOne(10L)));
		logger.info("selected two particular users");

		model.addAttribute("userForm", form);
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		User user;
		repository.deleteAll();
		for(int i= 1; i <= 10; i++) {
			user = new User();
			user.setName("user-"+i);
			repository.save(user);
		}
	}
}

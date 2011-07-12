package org.springframework.issues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.issues.domain.User;
import org.springframework.issues.service.UserService;
import org.springframework.issues.util.DBSetupExecutionListener;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@TestExecutionListeners({ DBSetupExecutionListener.class,
		DependencyInjectionTestExecutionListener.class })
public class ConfigurationBaseTest {

	@Autowired
	private UserService userService;

	@Test
	public void testSimpleProperties() throws Exception {
		assertNotNull(userService);
	}

	@Test
	public void testGetNames() throws Exception {
		List<String> names = userService.getNames();
		assertEquals(names.size(), 5);
	}

	@Test
	public void testAddUser() throws Exception {
		User user = new User();
		user.setId(100);
		user.setName("Neu");
		user.setCity("Zürich");
		userService.saveUser(user);
		List<String> names = userService.getNames();
		assertEquals(names.size(), 6);
		assertTrue(names.contains("Neu"));
	}

	@Test
	public void testUpdateUser() throws Exception {
		User user = new User();
		user.setId(100);
		user.setName("NeuDochAlt");
		user.setCity("Zürich");
		userService.saveUser(user);
		List<String> names = userService.getNames();
		assertEquals(names.size(), 6);
		assertTrue(names.contains("NeuDochAlt"));
	}

}

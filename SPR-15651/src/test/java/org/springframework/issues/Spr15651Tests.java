package org.springframework.issues;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
@ContextConfiguration(locations = { "config.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class Spr15651Tests {
	@Autowired
	/** SessionRegistry is used as the test service interface (nothing to do with the test) */
	private SessionRegistry sessionRegistry;

	@Test(expected = AccessDeniedException.class)
	public void securityInterceptorHandlesCallWithNoTargetObject() {
		SecurityContextHolder.getContext().setAuthentication(
				new UsernamePasswordAuthenticationToken("bob", "bobspassword"));
		sessionRegistry.getAllPrincipals();
	}

}

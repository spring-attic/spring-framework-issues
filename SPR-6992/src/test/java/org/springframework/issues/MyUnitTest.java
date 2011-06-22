package org.springframework.issues;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.issues.MyBean;
import org.springframework.issues.MyMockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:application-context.xml"})
public class MyUnitTest {

	@Autowired
	private MyBean bean;

	@Autowired
	private MyMockBean mock;

	@Test
	public void test() {
		Assert.assertEquals("org.springframework.issues", this.bean.getTest());
		Assert.assertEquals("mock", this.mock.getMock());
	}

}

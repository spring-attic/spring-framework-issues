package org.springframework.issues;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = MyConfiguration.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class MyServiceTest {

	@Autowired
	protected MyService service;

	@Test(expected = ConstraintViolationException.class)
	public void exceptionWhenBeanIsNull() {
		this.service.doSomething(null);
	}

	@Test(expected = ConstraintViolationException.class)
	public void exceptionWhenBeanIsInvalid() {
		this.service.doSomething(new MyBean());
	}

	@Test(expected = ConstraintViolationException.class)
	public void exceptionWhenBeanIsNullAsync() {
		this.service.doSomethingAsync(null);
	}

	@Test(expected = ConstraintViolationException.class)
	public void exceptionWhenBeanIsInvalidAsync() {
		this.service.doSomethingAsync(new MyBean());
	}
}

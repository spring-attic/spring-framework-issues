package org.springframework.issues.validation.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.issues.aop.AspectConfig;
import org.springframework.issues.validation.CustomerService;
import org.springframework.issues.validation.ValidationConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@ContextConfiguration(classes = { ValidationConfig.class, AspectConfig.class })
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTest {

    @Autowired
    private CustomerService service;

    @Test
    public void throwsViolationExceptionWhenAllArgumentsInvalid() {
        try {
            service.createUser(null, null, null);
        } catch (ConstraintViolationException ce) {
            assertSame(ce.getConstraintViolations().size() == 3, true);
        }
    }

    @Test
    public void createsUser() {
        try {
            service.createUser("user@domain.com", "valid", "valid");
        } catch (ConstraintViolationException ce) {
            assertSame(ce.getConstraintViolations().size() == 1, true);
            Set<ConstraintViolation<?>> violations = ce.getConstraintViolations();
            assertEquals("may not be empty", violations.iterator().next().getMessage());
        }
    }
}
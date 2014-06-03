/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.demo.demo;

import static org.junit.Assert.*;

import org.demo.demo.config.ApplicationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author pmr
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationConfig.class})
public class ReproTests {

	@Autowired
	private MyBean myBean;

	@Test
	public void testMyBean() {
		// Check MyBean @DependsOn annotation
		assertNotNull(myBean);
	}

}

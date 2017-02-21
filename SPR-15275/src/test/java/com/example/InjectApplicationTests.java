package com.example;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.InjectApplication.Bar;

@RunWith(SpringRunner.class)
@SpringBootTest
public class InjectApplicationTests {
	
	@Autowired
	Bar foo;

	@Test
	public void contextLoads() {
		assertNotNull(foo);
	}

}

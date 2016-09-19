package com.example;

import java.io.IOException;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ImportResource("classpath:/beans.xml")
public class RefreshApplication {

	public static void main(String[] args) throws IOException {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(RefreshApplication.class);
		Object foo = context.getBean("foo");
		System.out.println(foo);
		System.out.println("Make so change to the script and press enter to continue");
		System.in.read();
		System.out.println(foo);

	}

}

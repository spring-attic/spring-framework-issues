package com.example;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.stereotype.Component;

public class ComponentScanTest {

	@Test
	public void withScanner() {
		DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
		ClassPathBeanDefinitionScanner scanner = new ClassPathBeanDefinitionScanner(bf);
		scanner.scan("com.example");
		for (String name : bf.getBeanDefinitionNames()) {
			//System.out.println(name);
		}
	}

	@Test
	public void withACAC() {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
		ctx.scan("com.example");
		ctx.refresh();
	}

}

@Component
class WithNestedAnnotation {

	@Target({ ElementType.TYPE })
	@Retention(RetentionPolicy.RUNTIME)
	@Documented
	@Component
	public static @interface MyComponent {

		String value() default "";
	} 
}

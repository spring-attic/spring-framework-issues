package com.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class ShadedClasspathRootApplication {

	@Bean
	public LocalContainerEntityManagerFactoryBean entityManager() {
		LocalContainerEntityManagerFactoryBean bean = new LocalContainerEntityManagerFactoryBean();
		bean.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		bean.setPackagesToScan("com.example");
		return bean;
	}

	public static void main(String[] args) {
		new AnnotationConfigApplicationContext(ShadedClasspathRootApplication.class).close();
	}

}

package org.springframework.issues;

import javax.persistence.EntityManagerFactory;

import org.junit.Test;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;


public class ReproTests {

	@Test
	public void repro() {
		DefaultListableBeanFactory bf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(bf);
		reader.loadBeanDefinitions("classpath:/applicationContext-jpa.xml");

		EntityManagerFactory emf = bf.getBean(EntityManagerFactory.class);
		emf.createEntityManager(); // will fail if second line uncommented below
	}

	void _never_called() {
//		OtherType.someMethod(new MyEntity());		// uncommenting causes no failure
//		OtherType.someMethod(new MyEntitySub());	// uncommenting causes failure
	}

}

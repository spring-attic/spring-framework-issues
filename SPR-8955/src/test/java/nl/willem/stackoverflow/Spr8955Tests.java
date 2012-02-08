package nl.willem.stackoverflow;

import nl.willem.stackoverflow.Abstract.Concrete;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Spr8955Tests {

	@Test
	public void repro() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("context.xml");

        Concrete concrete = applicationContext.getBean(Concrete.class);
        concrete.inheritedMethod();
	}

}

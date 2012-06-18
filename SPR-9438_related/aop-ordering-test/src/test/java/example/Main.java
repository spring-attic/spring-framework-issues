package example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		CheckedInterface testBean = (CheckedInterface) context.getBean("checkedInterfaceImpl");
		
		testBean.checkedMethod();
	}

}

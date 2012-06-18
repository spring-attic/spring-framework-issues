package example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainWithConfigurationAnnotation {
	
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		CheckedInterface testBean = (CheckedInterface) context.getBean("checkedInterface");
		
		testBean.checkedMethod();
	}
	
}

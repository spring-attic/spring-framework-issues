import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Proof of different behaviour using java configuration versus xml configuration
 */
public class Spr8582Tests {

	@Test
	public void testXML() {
		ApplicationContext ctx =
			new ClassPathXmlApplicationContext("applicationcontext.xml");
		System.out.println((ctx.getBean("theOtherBean")));
	}


	@Test
	public void testJavaConfig() {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);
		System.out.println((ctx.getBean("theOtherBean")));
	}

}

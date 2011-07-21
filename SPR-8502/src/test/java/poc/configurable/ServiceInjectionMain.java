package poc.configurable;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * For comparison with {@link ServiceInjectionTests}, proving that the same
 * code run from a main method does not exhibit the weaving failure that
 * occurrs when running from a JUnit @Test method.
 */
public class ServiceInjectionMain {

	public static void main(String... args) {
		new GenericXmlApplicationContext("/application-context.xml");

		// Entity should now be enhanced
		Entity entity = new Entity();
		assertThat("service was not injected into @Configurable entity",
				entity.getService(), notNullValue());
	}

	/**
	 * When uncommented, this method interferes with weaving such that Entity does not
	 * get injected with its @Autowired Service.
	 */
	void someMethod(Entity entity) { }
}

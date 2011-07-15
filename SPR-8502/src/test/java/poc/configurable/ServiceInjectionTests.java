package poc.configurable;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;

public class ServiceInjectionTests {

	@Test
	public void testServiceInjection() {
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
	//void someMethod(Entity entity) { }
}

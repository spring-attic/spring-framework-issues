
package maventest.concurrency;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeansDefinition {

	public BeansDefinition() {
	}

	@Bean
	public TheBean bean() {
		return new TheBean();
	}
}

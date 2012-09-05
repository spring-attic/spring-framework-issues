package org.springsource.investigation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

@Profile("prod")
@Configuration
@PropertySource({ "classpath:prod-app.properties" })
public class App {

	@Autowired
	protected Environment environment;

	@Autowired
	protected ConfigurableApplicationContext context;

	@Bean
	public String foo() {
		this.environment.getProperty("appId");
		//assertThat(this.context.getEnvironment(), sameInstance(this.environment));
		System.out.println("testing this.environment");
		test(this.environment);
		System.out.println("testing this.context.getBF().getBean(Env.class)");
		test((Environment)this.context.getBeanFactory().getBean("environment"));
		System.out.println("testing this.context.getEnv()");
		test(this.context.getEnvironment());
		return "bogus";
	}

	private void test(Environment env) {
		if (this.context.getEnvironment() == env) {
			System.out.println("environment belongs to autowired app context");
		}
		else if (this.context.getParent().getEnvironment() == env){
			System.out.println("environment belongs to PARENT OF autowired app context");
		}
		else {
			System.out.println("environment is of unknown origin");
		}
	}
}

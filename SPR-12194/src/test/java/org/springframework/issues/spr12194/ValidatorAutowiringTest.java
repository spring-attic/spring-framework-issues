package org.springframework.issues.spr12194;

import javax.validation.Validator;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.stereotype.Component;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

public class ValidatorAutowiringTest {

	@Test
	public void explicitValidator() {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(MyValidatorConfiguration.class);
		context.setServletContext(new MockServletContext());
		context.refresh();

		context.getBean(Validator.class); // Fails as there are two Validator beans in the context
	}

	@Test
	public void noExplicitValidator() {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(MyConfiguration.class);
		context.setServletContext(new MockServletContext());
		context.refresh(); // Fails as there's no Validator bean in the context
	}

}

@Configuration
@ComponentScan
@EnableWebMvc
class MyConfiguration {

}

class MyValidatorConfiguration extends MyConfiguration {
	@Bean
	public Validator localValidatorFactoryBean() {
		return new LocalValidatorFactoryBean();
	}
}

@Component
class MyComponent {
	@Autowired
	private Validator validator;
}
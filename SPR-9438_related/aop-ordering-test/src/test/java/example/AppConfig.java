package example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import example.aop.CheckAfterAspect;
import example.aop.CheckAnotherAfterAspect;
import example.aop.CheckBeforeAspect;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
	
	@Bean
	public CheckBeforeAspect checkBeforeAspect() {
		return new CheckBeforeAspect();
	}
	
	@Bean
	public CheckAfterAspect checkAfterAspect() {
		return new CheckAfterAspect();
	}

	@Bean
	public CheckAnotherAfterAspect checkAnotherAfterAspect() {
		return new CheckAnotherAfterAspect();
	}
	
	@Bean
	public CheckedInterface checkedInterface() {
		return new CheckedInterfaceImpl();
	}
}

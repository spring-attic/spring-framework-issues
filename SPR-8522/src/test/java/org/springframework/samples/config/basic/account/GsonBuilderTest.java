package org.springframework.samples.config.basic.account;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.google.gson.GsonBuilder;

public class GsonBuilderTest {

	Log logger = LogFactory.getLog(GsonBuilderTest.class);

	@Test
	public void checkGsonBuilder() {
		// create the spring container using the AppConfig @Configuration class
		ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);

//		// retrieve the beans we'll use during testing
//		AccountRepository accountRepository = ctx.getBean(AccountRepository.class);
//		TransferService transferService = ctx.getBean(TransferService.class);
		GsonBuilder builder = (GsonBuilder)ctx.getBean("gsonBuilder");

		if(builder == null){
			logger.error("No builder");
		}
	}
}

//		// create accounts to test against
//		accountRepository.add(new Account("A123", 1000.00));
//		accountRepository.add(new Account("C456", 0.00));
//
//		// check account balances before transfer
//		assertThat(accountRepository.findById("A123").getBalance(), equalTo(1000.00));
//		assertThat(accountRepository.findById("C456").getBalance(), equalTo(0.00));
//
//		// perform transfer
//		transferService.transfer(100.00, "A123", "C456");
//
//		// check account balances after transfer
//		assertThat(accountRepository.findById("A123").getBalance(), equalTo(900.00));
//		assertThat(accountRepository.findById("C456").getBalance(), equalTo(100.00));


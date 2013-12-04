package org.springframework.issues;

import org.apache.log4j.Appender;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggingEvent;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.context.support.GenericXmlApplicationContext;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within need not pass with the green bar!
 * Rather they should fail in such a way that demonstrates the reported issue.
 */
public class ReproTests {

	@Test
	public void isWarning() {
		Logger logger = org.apache.log4j.Logger.getLogger(loggerName());

		Appender appender = nothingLoggedAppender();
		logger.addAppender(appender);
		try {
			GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
			ctx.load("classpath:org/springframework/issues/ReproTests-context.xml");
			ctx.refresh();

			ctx.getBean("foo");

			ctx.close();

		} finally {
			logger.removeAppender(appender);
		}
	}

	private Appender nothingLoggedAppender() {
		Appender appender = Mockito.mock(Appender.class);
		Mockito.doThrow(new RuntimeException("No log message was expected")).when(appender)
				.doAppend(Mockito.any(LoggingEvent.class));
		return appender;
	}

	private String loggerName() {
		try {
			/*
			 * Using reflection to make sure this class has not been renamed to something else. This class is NOT a part
			 * of public API.
			 */
			Class<?> clazz = Class.forName("org.springframework.aop.framework.CglibAopProxy");
			return clazz.getName();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
}

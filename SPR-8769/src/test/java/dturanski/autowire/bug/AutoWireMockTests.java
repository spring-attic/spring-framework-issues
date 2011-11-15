package dturanski.autowire.bug;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import org.apache.log4j.Logger;
import org.easymock.EasyMock;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AutoWireMockTests {
  ApplicationContext ctx;
  private static final Logger logger = Logger.getLogger(AutoWireMockTests.class);
  @Test 
  public void thisWorks() {	 
	  ctx = new ClassPathXmlApplicationContext("/AutoWireMockTest-context-works.xml");
  }
  
  @Test 
  public void thisFails() throws ClassNotFoundException {
	  try {
		  ctx = new ClassPathXmlApplicationContext("/AutoWireMockTest-context-fails.xml");
	  } catch (Exception e) {
		  logger.error(e.getMessage(),e);
		  fail();
	  }
  }
  
  @Test 
  public void thisAlsoWorks() {
	  ctx = new ClassPathXmlApplicationContext("/AutoWireMockTest-context-xml-di-works.xml");
  }
  
  @Test 
  public void thisAlsoWorksForSomeReason() {
	  ctx = new ClassPathXmlApplicationContext("/AutoWireMockTest-context-factory-init-works.xml");
	  Bar bar = ctx.getBean(Bar.class);
	  assertNotNull(bar.foo);
  }
}

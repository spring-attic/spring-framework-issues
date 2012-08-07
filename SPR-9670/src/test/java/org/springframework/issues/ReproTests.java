package org.springframework.issues;

import org.junit.Test;
import org.springframework.context.support.GenericXmlApplicationContext;
import org.springframework.util.StopWatch;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ReproTests {

    private static final int ITERATIONS = 10000;
    
	@Test
	public void repro() {
		StopWatch stopWatch = new StopWatch("Prototyped Bean Creation");
		
		// initial load
        stopWatch.start("Initializing");
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:org/springframework/issues/ReproTests-context.xml");
        ctx.refresh();
		ctx.getBean("ParentBeanGroup");
		stopWatch.stop();
		
		stopWatch.start("Creating");
	    for (int i = 0; i < ITERATIONS; i++) {
	        ctx.getBean("ParentBeanGroup");
	    }
	    stopWatch.stop();
	    System.out.println(stopWatch.prettyPrint());
	 }

}

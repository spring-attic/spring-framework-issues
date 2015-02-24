/**
 * 
 */
package org.springframework.issues;

import org.springframework.test.context.TestContext;
import org.springframework.test.context.TestExecutionListener;

/**
 * @author derickso
 *
 */
public class MyTestExecutionListener implements TestExecutionListener {
    protected static volatile boolean listenerRun = false;

    @Override
    public void beforeTestClass(TestContext testContext) throws Exception {
        listenerRun = true;
    }

    @Override
    public void prepareTestInstance(TestContext testContext) throws Exception {
        listenerRun = true;
    }

    @Override
    public void beforeTestMethod(TestContext testContext) throws Exception {
        listenerRun = true;
    }

    @Override
    public void afterTestMethod(TestContext testContext) throws Exception {
    }

    @Override
    public void afterTestClass(TestContext testContext) throws Exception {
    }

    public static boolean isListenerRun() {
        return listenerRun;
    }
}

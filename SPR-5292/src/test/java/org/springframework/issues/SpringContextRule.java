package org.springframework.issues;

import java.lang.reflect.Method;

import org.junit.rules.MethodRule;
import org.junit.runners.model.FrameworkMethod;
import org.junit.runners.model.Statement;
import org.springframework.test.context.TestContextManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * WARNING: PROOF OF CONCEPT. DO NOT ASSUME PRODUCTION CODE ;)
 * 
 * A {@Rule} alternative to {@link SpringJUnit4ClassRunner}.
 * <p>
 * Currently used as follows:
 * 
 * <pre>
 * &#064;Rule
 * public static SpringContextRule rule = new SpringContextRule();
 * </pre>
 * 
 * Code borrowed from SPR-7731. Note that {@link MethodRule} is deprecated in recent versions of JUnit but there is some
 * discussion about whether it ought to be re-instated (<a href="https://github.com/KentBeck/junit/issues/351">on
 * github</a>).
 * 
 * @author Neale Upstone (skype: neale87)
 * @author Dave Syer
 */
public class SpringContextRule implements MethodRule {

	// private static final Log logger = LogFactory.getLog(SpringContextRule.class);

	private TestContextManager testContextManager;

	/**
	 * Currently the only way to create a SpringContextRule. The rule will look for the usual Spring annotations etc on
	 * the test classes that this rule is applied to.
	 */
	public SpringContextRule() {
	}

	public Statement apply(final Statement base, final FrameworkMethod method, final Object target) {

		// TODO: clean this up
		if (testContextManager == null) {
			testContextManager = createTestContextManager(target.getClass());
		}

		return new Statement() {
			@Override
			public void evaluate() throws Throwable {
				Method testMethod = method.getMethod();
				getTestContextManager().prepareTestInstance(target);
				getTestContextManager().beforeTestMethod(target, testMethod);
				Exception thrown = null;
				try {
					base.evaluate();
				}
				catch (Exception e) {
					thrown = e;
				}
				finally {
					getTestContextManager().afterTestMethod(target, testMethod, thrown);
				}
			}
		};
	}

	private TestContextManager getTestContextManager() {
		return testContextManager;
	}

	/**
	 * Creates a new {@link TestContextManager} for the supplied test class and the configured
	 * <em>default <code>ContextLoader</code> class name</em>. Can be overridden by subclasses.
	 * 
	 * @param clazz the test class to be managed
	 * @see #getDefaultContextLoaderClassName(Class)
	 */
	protected TestContextManager createTestContextManager(Class<?> clazz) {
		return new TestContextManager(clazz, getDefaultContextLoaderClassName(clazz));
	}

	/**
	 * Get the name of the default <code>ContextLoader</code> class to use for the supplied test class. The named class
	 * will be used if the test class does not explicitly declare a <code>ContextLoader</code> class via the
	 * <code>&#064;ContextConfiguration</code> annotation.
	 * <p>
	 * The default implementation returns <code>null</code>, thus implying use of the <em>standard</em> default
	 * <code>ContextLoader</code> class name. Can be overridden by subclasses.
	 * </p>
	 * 
	 * @param clazz the test class
	 * @return <code>null</code>
	 */
	protected String getDefaultContextLoaderClassName(Class<?> clazz) {
		return null;
	}

}

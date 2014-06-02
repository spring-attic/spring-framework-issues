package org.springframework.issues;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.boot.autoconfigure.PropertyPlaceholderAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.JpaBaseConfiguration;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within need
 * not pass with the green bar! Rather they should fail in such a way that demonstrates
 * the reported issue.
 */
public class ReproTests {

	@Test
	public void ok() throws Exception {
		assertNotNull(getClass().getClassLoader().loadClass(
				JpaBaseConfiguration.class.getName()));
	}

	/**
	 * This one is fine because it uses an ImportSelector (the same would be true if using
	 * <code>@EnableAutoConfiguration</code>).
	 */
	@Test
	public void clean() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(MainConfiguration.class);
		context.refresh();
		assertNotNull(context);
	}

	/**
	 * This one is fails because it uses <code>@Import</code> (and
	 * {@link HibernateJpaAutoConfiguration} has an unloadable nested class).
	 */
	@Test
	public void dirty() throws Exception {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		context.register(ImportConfiguration.class);
		context.refresh();
		assertNotNull(context);
	}

	@Configuration
	@Import({ DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class,
			PropertyPlaceholderAutoConfiguration.class })
	protected static class ImportConfiguration {
	}

	@Configuration
	@Import(Selector.class)
	protected static class MainConfiguration {
	}

	protected static class Selector implements ImportSelector {

		@Override
		public String[] selectImports(AnnotationMetadata importingClassMetadata) {
			return new String[] { DataSourceAutoConfiguration.class.getName(),
					HibernateJpaAutoConfiguration.class.getName(),
					PropertyPlaceholderAutoConfiguration.class.getName() };
		}

	}

}

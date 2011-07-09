package org.springframework.issues;

import org.springframework.issues.configuration.AppConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes = AppConfig.class)
public class ConfigurationJavaConfigHibernateTests extends
		ConfigurationBaseTest {

}

package org.mycompany.audit;

import org.mycompany.audit.config.AppConfig;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

@ContextConfiguration(loader = AnnotationConfigContextLoader.class, classes =
{
  AppConfig.class
})
@ActiveProfiles("UNIT_TEST")
public abstract class BaseTestClass extends AbstractJUnit4SpringContextTests
{
}

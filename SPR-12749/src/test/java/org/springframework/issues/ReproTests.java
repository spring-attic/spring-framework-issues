package org.springframework.issues;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.util.MetaAnnotationUtils;
import org.springframework.test.util.MetaAnnotationUtils.AnnotationDescriptor;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
@MyMetaAnnotation
public class ReproTests extends AbstractJUnit4SpringContextTests {
    @Test
    public void repro() {
        AnnotationDescriptor<TestExecutionListeners> descriptor = MetaAnnotationUtils.findAnnotationDescriptor(ReproTests.class,
                TestExecutionListeners.class);
        Assert.assertTrue(MyTestExecutionListener.isListenerRun());
        Class<?>[] classes = (Class<?>[]) descriptor.getAnnotationAttributes().get("value");
        Assert.assertEquals(1, classes.length);
        Assert.assertEquals(MyTestExecutionListener.class, classes[0]);
    }
}

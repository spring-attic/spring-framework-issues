package org.springframework.issues;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class Spr10918Test {
    @Test
    public void shouldInvokeRegistrarOnlyOnce() {
        final AnnotationConfigApplicationContext myContext = new AnnotationConfigApplicationContext();
        myContext.scan(getClass().getPackage().getName());
        myContext.refresh();
        assertThat(TestImport.theInvocations, is(1));
    }
}
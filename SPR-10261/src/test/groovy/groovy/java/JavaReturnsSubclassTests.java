package groovy.java;

import groovy.groovy.GroovyReturnsSubclassTests;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Same as {@link GroovyReturnsSubclassTests} except it is .java file.
 * Demonstrates that this issue is probably Groovy related?
 *
 * @author Rob Winch
 * @see GroovyReturnsSubclassTests
 * @see GroovyReturnsSubclassTests
 */
public class JavaReturnsSubclassTests {
    private AnnotationConfigApplicationContext context;

    @Test
    public void returnsSubclass() {
        for(int i=0;i < 1;i++) {
            try {
                context = new AnnotationConfigApplicationContext(MyConfig.class);
            } finally {
                if(context != null) {
                    context.close();
                }
            }
        }
    }

    @Configuration
    static class MyConfig extends BaseConfig {
        @Bean
        public String builder() throws Exception {
            return null;
        }
    }

    @Configuration
    static abstract class BaseConfig {

        public abstract Object builder() throws Exception;
    }
}

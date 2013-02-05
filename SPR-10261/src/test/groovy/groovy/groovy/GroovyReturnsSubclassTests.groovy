package groovy.groovy;

import groovy.java.JavaReturnsSubclassTests;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * This class fails with {@link NoClassDefFoundError} randomly.
 *
 * @author Rob Winch
 * @see GroovyReturnsSubclassTests
 * @see JavaReturnsSubclassTests
 */
public class GroovyReturnsSubclassTests {
    private AnnotationConfigApplicationContext context;

    @Test
    public void returnsSubclass() {
        context = new AnnotationConfigApplicationContext(MyConfig.class);
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

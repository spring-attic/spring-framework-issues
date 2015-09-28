package groovy.groovy;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * If the declared types of the BaseConfig and MyConfig are the same on the method
 * signature the issue does not seem to happen.
 *
 * @author Rob Winch
 * @see GroovyReturnsSubclassTests
 * @see JavaReturnsSubclassTests
 */
public class GroovyReturnsSameTests {
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
        public Object builder() throws Exception {
            return null;
        }
    }

    @Configuration
    static abstract class BaseConfig {

        public abstract Object builder() throws Exception;
    }
}

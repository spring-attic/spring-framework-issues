package org.springframework.issues;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.mock.web.MockServletContext;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.context.support.ServletContextAwareProcessor;

/**
 * Unit test that reproduces an issue reported against SPR JIRA. @Test methods within
 * need not pass with the green bar! Rather they should fail in such a way that
 * demonstrates the reported issue.
 */
public class ReproTests {

    @Test
    public void should_create_context_with_circular_references() {
        contextWithCircularReferences( true );
    }

    @Test
    public void should_create_context_without_circular_references() {
        contextWithCircularReferences( false );
    }

    public void contextWithCircularReferences( boolean allowCircular ) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        try {
            ctx.setAllowCircularReferences( allowCircular );
            ctx.register( MockBaseConfiguration.class, DummySecurityConfiguration.class );
            ctx.refresh();
        }
        finally {
            ctx.close();
        }
    }

    @Configuration
    public static class MockBaseConfiguration {
        @Bean
        public MockServletContext servletContext() {
            return new MockServletContext();
        }

        @Bean
        public MockServletConfig servletConfig() {
            return new MockServletConfig( servletContext() );
        }

        @Bean
        public ServletContextAwareProcessor servletContextAwareProcessor() {
            return new ServletContextAwareProcessor( servletContext(), servletConfig() );
        }
    }

    @Configuration
    @EnableWebSecurity
    public static class DummySecurityConfiguration extends WebSecurityConfigurerAdapter {
        @Override
        protected void configure( AuthenticationManagerBuilder auth ) throws Exception {
        }
    }
}

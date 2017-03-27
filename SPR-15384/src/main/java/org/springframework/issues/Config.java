package org.springframework.issues;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ConfigurationCondition;
import org.springframework.context.annotation.ConfigurationCondition.ConfigurationPhase;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.core.type.AnnotatedTypeMetadata;

@Configuration
public class Config {

    public static final String BEAN_NAME = "name";
    
    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Conditional(OnBeanMissingCondition.class)
    public class MemberBefore {
        
        @Bean(BEAN_NAME)
        public Foo foo() {
            return new Foo();
        }
        
    }

    @Order(Ordered.LOWEST_PRECEDENCE)
    @Conditional(OnBeanMissingCondition.class)
    public class MemberAfter {
        
        @Bean(BEAN_NAME)
        public Bar bar() {
            return new Bar();
        }
        
    }
    
    // based on org.springframework.boot.autoconfigure.condition.OnBeanCondition
    public static class OnBeanMissingCondition implements ConfigurationCondition {


        @Override
        public ConfigurationPhase getConfigurationPhase() {
            return ConfigurationPhase.REGISTER_BEAN;
        }
        
        @Override
        public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
            return !context.getBeanFactory().containsBeanDefinition(BEAN_NAME);
        }

    }

}

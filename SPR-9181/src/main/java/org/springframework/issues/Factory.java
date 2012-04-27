package org.springframework.issues;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;

import javax.inject.Named;
import javax.inject.Provider;

import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

/**
 * TODO Beschreibung angeben
 *
 * @author andr
 */
@Named
@Lazy(false)
public class Factory {
    @Bean
    @Scope(SCOPE_PROTOTYPE)
    public Foo testFactory(
            final Provider<ProviderClass<String, String>> testProvider
    ) {
        return new Foo(testProvider);
    }
}

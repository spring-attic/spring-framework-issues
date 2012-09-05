package org.springsource.investigation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

abstract class BaseConfig {

    @Autowired
    protected Environment environment;

    @Bean
    public AppIdStringWrapper connectionFactoryLocator()
    {
        return new AppIdStringWrapper(environment.getProperty("appId"));
    }
}

class AppIdStringWrapper {
    private String profileName;

    public AppIdStringWrapper(String profileName) {
        this.profileName = profileName;
    }

    public String getProfileName() {
        return this.profileName;
    }
}


@Profile("prod")
@Configuration
@PropertySource({ "classpath:prod-app.properties" })
class ProdConfig extends BaseConfig {
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Profile("dev")
@interface Dev {
}

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Profile("prod")
@interface Prod {
}

@Service
public class App {

    @Autowired
    AppIdStringWrapper appIdStringWrapper;

    public void testApp()
    {
    }
}

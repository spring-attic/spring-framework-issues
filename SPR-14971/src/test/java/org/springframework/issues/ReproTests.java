package org.springframework.issues;

import java.util.Arrays;
import java.util.Collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ConversionServiceFactoryBean;
import org.springframework.core.convert.ConversionService;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DirtiesContext
@ContextConfiguration( classes = { ReproTests.Configuration.class })
public class ReproTests {
    @Autowired
    ConversionService service;

    @Test
    public void testConversionService() {
        Collection<?> source = Arrays.asList(new Person("Name", 30));

        if (service.canConvert(source.getClass(), String.class)) {
            service.convert(source, String.class);
        }
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Person {
        private String name;
        private int age;
    }

    public static class Configuration {
        @Bean
        ConversionServiceFactoryBean defaultConversionServiceFactoryBean() {
            return new ConversionServiceFactoryBean();
        }
    }
}

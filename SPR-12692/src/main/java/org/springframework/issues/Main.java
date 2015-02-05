package org.springframework.issues;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@EnableAutoConfiguration
public class Main {

    public static void main(String[] args) {
        new SpringApplicationBuilder(Main.class).showBanner(false).run(args);
    }

}

package org.springframework.issues;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jpa.JpaRepositoriesAutoConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Greg Potter
 * @since 10/17/17
 */
@SpringBootApplication(exclude = JpaRepositoriesAutoConfiguration.class)
public class Application implements CommandLineRunner {

    @Transactional
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Hi");
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }

}

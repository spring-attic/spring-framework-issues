package org.springframework.issues

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class App {

    public static void main(String[] args) {
        SpringApplication.run(App, args)
                .with { it.getBean(DogService) }
                .with { it.introduce 'Curly' }
                .with { println it }
    }

}

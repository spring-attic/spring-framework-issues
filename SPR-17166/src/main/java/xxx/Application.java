package xxx;

import java.time.Instant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@SpringBootApplication
@EnableScheduling
public class Application {

    @Service
    @Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
    public static class A {

        @Scheduled(fixedDelay = 1000)
        public void task() {
            System.out.println(Instant.now());
        }

    }

    @Service
    public static class B {

        private final A a;

        B(A a) {
            this.a = a;
        }

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
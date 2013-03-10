package t;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Author: Alexander Ivkin
 * Date: 2/24/13
 */
@Configuration
public class B {
    @Bean
    public MyBean b() {
        return new MyBean();
    }
}
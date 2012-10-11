package spring.config.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import spring.config.MyBean;
import spring.config.MyBeanImpl;

/**
 * @author jbaruch
 * @since 10/10/12
 */
@Configuration
@EnableAspectJAutoProxy
public class ApplicationConfiguration {

    @Bean
    public MyBean myBean(){
        return new MyBeanImpl();
    }

}

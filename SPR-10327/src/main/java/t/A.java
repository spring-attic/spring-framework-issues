package t;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * Author: Alexander Ivkin
 * Date: 2/24/13
 */
@Configuration
@Import(B.class)
public class A {
    @Autowired
    private MyBean myBean;
}
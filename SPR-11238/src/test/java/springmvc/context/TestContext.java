package springmvc.context;

import springmvc.model.Member;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import springdao.DaoManager;
import springdao.RepositoryManager;

/**
 *
 * @author kent Yeh
 */
@Configuration
@ImportResource({"classpath:testContext.xml"})
public class TestContext {

    @DaoManager
    private RepositoryManager<Member> memberManager;

    @Bean
    public RepositoryManager<Member> memberManager() {
        return memberManager;
    }
}

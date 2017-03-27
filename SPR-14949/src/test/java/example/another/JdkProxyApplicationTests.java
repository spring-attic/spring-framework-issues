package example.another;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest("spring.aop.proxy-target-class=false")
public class JdkProxyApplicationTests {
	
	@Autowired
	private AsyncService service;

	@Test
	public void contextLoads() throws Exception {
		String result = service.getResponse().get();
		assertThat(result).contains("enhanced");
		assertThat(result).contains("TaskExecutor");
	}

}

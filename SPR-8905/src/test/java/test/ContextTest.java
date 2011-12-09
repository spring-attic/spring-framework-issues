package test;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ContextTest {

	@Test
	public void repro() {
		AnnotationConfigApplicationContext ctx =
				new AnnotationConfigApplicationContext();
		ctx.register(FirstDao.class);
		ctx.register(SecondDao.class);
		ctx.register(FirstService.class);
		ctx.register(SecondService.class);
		ctx.refresh();
	}

}

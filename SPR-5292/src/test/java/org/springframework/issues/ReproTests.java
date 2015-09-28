package org.springframework.issues;

import static org.hamcrest.CoreMatchers.sameInstance;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration("classpath:org/springframework/issues/ReproTests-context.xml")
@RunWith(Parameterized.class)
public class ReproTests {
	
	@Rule
	public static SpringContextRule context = new SpringContextRule();
	
	@Autowired
	private Foo foo;

	@Autowired
	private Bar bar;

	private final String value;
	
	private static Foo state;
	
	@Parameters	
	public static List<Object[]> parameters() {
		return Arrays.asList(new Object[] {"foo"}, new Object[] {"bar"});
	}
	
	public ReproTests(String value) {
		this.value = value;
	}

	@Test
	public void repro() {
		System.err.println(value);
		if (state==null) {
			state = foo;
		} else {
			// Context is only created once so the singleton instance shoul be the same
			assertThat(state, sameInstance(foo));
		}
		assertThat(foo.getBar(), sameInstance(bar));
	}

}

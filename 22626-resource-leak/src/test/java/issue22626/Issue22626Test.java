package issue22626;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.io.InputStream;
import java.util.function.Supplier;

import org.apache.commons.io.input.NullInputStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Issue22626Test {

	@Autowired
	private MockMvc mvc;

	private final InputStream stream = spy(new NullInputStream(1000));

	@MockBean
	private Supplier<InputStream> source;

	@Before
	public void setupSource() {
		when(source.get()).thenReturn(stream);
	}

	@Test
	public void ifModifiedSinceShouldCloseResource() throws Exception {
		mvc.perform(get("/").header("if-modified-since", "Thu, 01 Jan 1970 00:00:22 GMT")).andExpect(r -> {
			assertEquals(304, r.getResponse().getStatus());
			verify(stream, times(1)).close();
		});
	}

	@Test
	public void ifNoneMatchShouldCloseResource() throws Exception {
		mvc.perform(get("/").header("if-none-match", "\"Issue22626\"")).andExpect(r -> {
			assertEquals(304, r.getResponse().getStatus());
			verify(stream, times(1)).close();
		});
	}

	@Test
	public void downloadingShouldCloseResource() throws Exception {
		mvc.perform(get("/")).andExpect(r -> {
			assertEquals(200, r.getResponse().getStatus());
			verify(stream, times(1)).close();
		});
	}
}

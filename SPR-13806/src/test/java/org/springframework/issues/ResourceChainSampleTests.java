package org.springframework.issues;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.handler.SimpleUrlHandlerMapping;
import org.springframework.web.servlet.resource.CssLinkResourceTransformer;
import org.springframework.web.servlet.resource.PathResourceResolver;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;
import org.springframework.web.servlet.resource.ResourceResolver;
import org.springframework.web.servlet.resource.ResourceTransformer;
import org.springframework.web.servlet.resource.VersionResourceResolver;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:mvc-resources-sample.xml")
@WebAppConfiguration
public class ResourceChainSampleTests {

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Test
	public void shouldNotRegisterDefaultResourceChain() throws Exception {
		SimpleUrlHandlerMapping mapping = webApplicationContext.getBean(SimpleUrlHandlerMapping.class);
		assertNotNull(mapping);
		assertNotNull(mapping.getUrlMap().get("/resources/**"));
		ResourceHttpRequestHandler handler = webApplicationContext.getBean((String) mapping.getUrlMap().get("/resources/**"),
				ResourceHttpRequestHandler.class);
		assertNotNull(handler);

		List<ResourceResolver> resolvers = handler.getResourceResolvers();
		assertEquals(resolvers.size(), 2);
		assertEquals(VersionResourceResolver.class, resolvers.get(0).getClass());
		assertEquals(PathResourceResolver.class, resolvers.get(1).getClass());

		List<ResourceTransformer> transformers = handler.getResourceTransformers();
		assertEquals(transformers.size(), 1);
		assertEquals(CssLinkResourceTransformer.class, transformers.get(0).getClass());
	}
}

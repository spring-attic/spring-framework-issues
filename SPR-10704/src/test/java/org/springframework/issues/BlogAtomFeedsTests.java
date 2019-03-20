package org.springframework.issues;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.bootstrap.context.initializer.ConfigFileApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.ByteArrayInputStream;
import java.io.IOException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.xpath;


@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = ApplicationConfiguration.class, initializers = ConfigFileApplicationContextInitializer.class)
public class BlogAtomFeedsTests {

	@Autowired
	private WebApplicationContext wac;

	private MockMvc mockMvc;

	private XPath xpath = XPathFactory.newInstance().newXPath();

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
	}

	/* This doesn't work !!!! */
	@Test
	public void feedHasCorrectMetadataMockMvcXpath() throws Exception {
		mockMvc.perform(get("/blog.atom"))
				.andExpect(xpath("/feed/title").string("Test Feed"))
				.andExpect(xpath("/feed/icon").string("https://www.example.com/favicon.ico"))
				.andReturn();
	}

	/* It works this way, but we shouldn't have to do this */
	@Test
	public void feedHasCorrectMetadataManualXpath() throws Exception {
		Document doc = doGetForDocument("/blog.atom");

		assertThat(xpath.evaluate("/feed/title", doc), is("Test Feed"));
		assertThat(xpath.evaluate("/feed/icon", doc), is("https://www.example.com/favicon.ico"));
	}

	private Document doGetForDocument(String path) throws Exception {
		ResultActions resultActions = mockMvc.perform(get(path));
		MvcResult mvcResult = resultActions.andReturn();
		return getAtomFeedDocument(mvcResult);
	}

	private Document getAtomFeedDocument(MvcResult mvcResult) throws ParserConfigurationException, SAXException, IOException {
		String atomFeed = mvcResult.getResponse().getContentAsString();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		DocumentBuilder builder = factory.newDocumentBuilder();
		return builder.parse(new ByteArrayInputStream(atomFeed.getBytes()));
	}
}

package org.springframework.issues;

import net.sf.json.JSONObject;
import org.apache.commons.httpclient.HttpClient;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.client.CommonsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.Matchers.isEmptyString;
import static org.junit.Assert.assertThat;

public class RestTemplateTest {

        private static final String CURRENCY_CONVERTER_QUERY = "http://www.google.com/ig/calculator?q=1USD=?EUR";

    private RestTemplate restTemplate;

    @Before
    public void setUp() {
        restTemplate = new RestTemplate(new CommonsClientHttpRequestFactory(new HttpClient()));
    }

    @Test
    public void shouldName() {
        String response = restTemplate.getForObject(CURRENCY_CONVERTER_QUERY, String.class);
        JSONObject jsonObject = JSONObject.fromObject(response);

        System.out.println(response);
        System.out.println(jsonObject);

        String error = jsonObject.getString("error");

        assertThat(error, isEmptyString());
    }

}

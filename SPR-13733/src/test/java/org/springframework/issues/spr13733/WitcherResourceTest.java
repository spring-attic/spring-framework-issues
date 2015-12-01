package org.springframework.issues.spr13733;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.issues.spr13733.web.WitcherResponse;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestOperations;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
@IntegrationTest
public class WitcherResourceTest {

    private static final boolean SEND_WITH_PARAMS_IN_URL = true;

    private static final boolean SEND_WITH_PARAMS_IN_BODY = false;

    @Autowired
    private RestOperations restOperations;

    private void shouldAcceptContract(final boolean sendWithParamsInUrl) {
        // given
        String url = "/witcher/contract/validate";

        final String contract = "The Apiarian Phantom";
        final String beast = "Wild Hunt Hound";
        final String reward = "120 crowns";

        final MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<>();

        if (sendWithParamsInUrl) {
            url += "?contract=" + contract + "&beast=" + beast + "&reward=" + reward;
        } else {
            parameters.add("contract", contract);
            parameters.add("beast", beast);
            parameters.add("reward", reward);
        }

        // when
        final WitcherResponse witcherResponse = restOperations
            .postForObject(url, parameters, WitcherResponse.class);

        // then
        assertThat(witcherResponse.isAccepted()).isTrue();
    }

    @Test
    public void shouldAcceptContractWhenPostRequestSentWithParamsInUrl() throws Exception {
        shouldAcceptContract(SEND_WITH_PARAMS_IN_URL);
    }

    @Test
    public void shouldAcceptContractWhenPostRequestWithParamsInBody() throws Exception {
        shouldAcceptContract(SEND_WITH_PARAMS_IN_BODY);
    }

}

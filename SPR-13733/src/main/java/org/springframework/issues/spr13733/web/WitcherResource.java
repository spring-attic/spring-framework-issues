package org.springframework.issues.spr13733.web;

import static org.springframework.http.MediaType.APPLICATION_FORM_URLENCODED_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/witcher/contract")
public class WitcherResource {

    private static final Logger log = LoggerFactory.getLogger(WitcherResource.class);

    @RequestMapping(value = "validate", method = POST, consumes = APPLICATION_FORM_URLENCODED_VALUE, produces = APPLICATION_JSON_VALUE)
    public WitcherResponse validateContract(@RequestBody final MultiValueMap<String, String> data) {
        log.info("Witcher contract: {}", data);

        final WitcherResponse witcherResponse = new WitcherResponse();
        witcherResponse.setAccepted(true);
        return witcherResponse;
    }
}

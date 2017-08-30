package org.springframework.issues.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.issues.model.ThingRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @ResponseBody
    @RequestMapping(value = "/do-the-thing", method = RequestMethod.GET)
    public void doTheThing(
            @Valid ThingRequest thingRequest
    ) {
        logger.warn("In handler, ids: {}", thingRequest.getThingIds());
    }

}

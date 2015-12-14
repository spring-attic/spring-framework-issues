/* ***************************************************************************
 * Copyright 2015 VMware, Inc.  All rights reserved.
 * -- VMware Confidential
 * **************************************************************************/
package com.repro;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EndpointController {

    @RequestMapping(value="/sleepingendpoint", method=GET)
    public @ResponseBody String endpoint() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        return "{}";
    }

}

/*******************************************************************************
 * Copyright (c) 2001 - 2012  TVWorks, Inc.  All rights reserved.
 *******************************************************************************/

package com.eric;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller public class WorldController {
    @RequestMapping(value = "/world", method = RequestMethod.GET)
    @ResponseBody public Hello sayHello() {
        return new Hello();
    }
}

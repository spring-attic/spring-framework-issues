package org.springframework.issues.config;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.resource.ResourceUrlProvider;

@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

    @Autowired
    private ResourceUrlProvider resourceUrlProvider;

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String home(HttpServletRequest request) {
        try {
            logger.debug("css =  '{}'", this.resourceUrlProvider.getForLookupPath("/static/test.css"));
        } catch (Exception exception) {
            // TODO Auto-generated catch block
            exception.printStackTrace();
        }
        return "home";
    }

}

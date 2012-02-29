package org.springframework.issues.spr9157.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.issues.spr9157.model.EnhancedEnvironment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for managing environment.
 * 
 * @author ferengra
 */
@Controller
public class EnvironmentController {
    private static final Logger LOG = LoggerFactory.getLogger(EnvironmentController.class);

    @RequestMapping(value = "/environments.html", method = RequestMethod.GET)
    public ModelAndView getEnvironments() {
        LOG.debug("environments");
        return new ModelAndView("environments");
    }

    @RequestMapping(value = "/environment.html", method = RequestMethod.GET)
    public ModelAndView getEnvironment(@RequestParam EnhancedEnvironment environment) {
        LOG.debug("environment: {}", environment);
        ModelAndView mav = new ModelAndView("environment");
        mav.addObject("environment", environment);
        return mav;
    }
}

package com.spring.test.webservice.pub;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
  /** */
  private static final Logger LOG = LoggerFactory.getLogger(MainController.class);

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public void getDefaultIndexView(HttpServletRequest request, HttpServletResponse response, final Model model) {
    LOG.debug("index page requested (/)");
    try {
      response.sendRedirect("index.html");
    } catch (IOException e) {
      LOG.error("index page / requested: {}", e.getStackTrace());
    }
  }

  @RequestMapping(value = "/index", method = RequestMethod.GET)
  public String getIndexView(final Model model) {
    LOG.debug("index page requested");
    model.addAttribute("AppName", "test");
    model.addAttribute("AppURL", "static/use/V0.0.1/index.html");
    return "index";
  }

}

package com.spring.test.webservice.use;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ch.qos.logback.classic.Logger;

@Controller
@RequestMapping(value = "/api/use/action")
public class ActionController {

  /** */
  private static final Logger LOG = (Logger) LoggerFactory.getLogger(ActionController.class);

  /** Controller for getActionList method. */
  @RequestMapping(value = "", method = RequestMethod.GET)
  public @ResponseBody
  Model getActionList(final HttpServletResponse response, final Model model) {
    LOG.debug("webservice: getActionList");
    long start = java.lang.System.nanoTime();
    model.addAttribute("action", "getActionList");
    model.addAttribute("timeTracking", System.nanoTime() - start);
    return model;
  }

  /** */
  @RequestMapping(value = "", method = RequestMethod.POST)
  public @ResponseBody
  Model insertAction(@RequestBody String iAction, final HttpServletResponse response, final Model model) {
    LOG.debug("webservice: insertAction");
    long start = java.lang.System.nanoTime();
    model.addAttribute("action", "updateAction");
    model.addAttribute("timeTracking", System.nanoTime() - start);
    return model;
  }

  /** */
  @RequestMapping(method = RequestMethod.PUT)
  public @ResponseBody
  Model updateAction(@RequestBody final String iAction, final HttpServletResponse response, final Model model) {
    LOG.debug("webservice: updateAction");
    long start = java.lang.System.nanoTime();
    model.addAttribute("action", "updateAction");
    model.addAttribute("timeTracking", System.nanoTime() - start);
    return model;
  }

  /** */
  @RequestMapping(value = "/{iid}", method = RequestMethod.DELETE)
  public @ResponseBody
  Model deleteAction(@PathVariable final Long iid, final Model model, final HttpServletResponse response) {
    LOG.debug("webservice: deleteAction");
    final long start = System.nanoTime();
    model.addAttribute("action", "deleteAction");
    model.addAttribute("timeTracking", System.nanoTime() - start);
    return model;
  }

}

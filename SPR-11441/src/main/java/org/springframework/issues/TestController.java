package org.springframework.issues;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author cartedan
 *
 */
@Controller
public class TestController {

    public TestController() {
        String s = "asdf";
    }

    Logger log = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/circuit/{id}", method = RequestMethod.GET)
    public String getCircuit(@PathVariable String id, Model model) {
        log.info("ID Received: {}", id);
        model.addAttribute("receivedId", id);
        return "result";
    }

}

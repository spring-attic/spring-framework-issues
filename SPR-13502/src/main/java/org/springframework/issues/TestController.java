package org.springframework.issues;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    private Logger logger = LoggerFactory.getLogger(TestController.class);

    @RequestMapping(value = "/")
    public String index(@ModelAttribute MyForm myForm, Model model) {

        if(myForm.getProjects() == null) {
            logger.info("myForm.projects Set is null");
        }
        else if(myForm.getProjects().isEmpty()) {
            logger.info("myForm.projects Set is an empty set");
        }

        model.addAttribute("listedProjects", SpringProjects.values());
        return "index";
    }

}
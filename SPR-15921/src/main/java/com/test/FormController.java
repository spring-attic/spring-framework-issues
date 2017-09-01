package com.test;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jean-charles_eloi on 01/09/17.
 */
@Controller
public class FormController {

    @GetMapping(path = "/edit")
    public String index(final Model model) {

        SimpleBean bean = new SimpleBean();
        bean.setBar("Barbar");
        bean.setFoo("Foofoo");

        model.addAttribute("simplebean", bean);

        return "form/edit";
    }


    @PutMapping(path="/save")
    public String update(@ModelAttribute SimpleBean simpleBean) {

        //Spring Boot 1.5.4.RELEASE (Spring-Web 4.3.9.RELEASE)  -> no NullPointer, the bean is populated
        //Spring Boot 1.5.5/6.RELEASE (Spring-Web 4.3.10.RELEASE)  -> NullPointer, the bean is empty

        return simpleBean.getFoo().toString() + simpleBean.getBar().toString();
    }

}

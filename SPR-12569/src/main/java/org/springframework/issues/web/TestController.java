package org.springframework.issues.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class TestController {

    @RequestMapping("/")
    @ResponseBody
    String hello(ModelMap model) {
        String name = (String)model.getOrDefault("name", "???");
        return "Hello, " + name + "!";
    }

    @RequestMapping("/test1") // OK
    String test1(RedirectAttributes redir) {
        redir.addFlashAttribute("name", "World");
        return "redirect:/";
    }

    @RequestMapping("/test2") // OK
    String test2(RedirectAttributes redir) {
        redir.addFlashAttribute("name", "World");
        return "redirect:/?param=1";
    }

    @RequestMapping("/test3") // NOT WORKING
    String test3(RedirectAttributes redir) {
        redir.addFlashAttribute("name", "World");
        return "redirect:/?param=1+2";
    }

    @RequestMapping("/test4") // NOT WORKING
    String test4(RedirectAttributes redir) {
        redir.addFlashAttribute("name", "World");
        redir.addAttribute("param", "1 2");
        return "redirect:/";
    }

}

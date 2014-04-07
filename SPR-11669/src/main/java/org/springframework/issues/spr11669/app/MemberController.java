package org.springframework.issues.spr11669.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.issues.spr11669.domain.model.Member;
import org.springframework.issues.spr11669.domain.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@RequestMapping("members")
@Controller
public class MemberController {

    @Autowired
    MemberService memberService;

    @ModelAttribute
    public Member setUpMember() {
        return new Member();
    }

    @RequestMapping(value = "create", method = RequestMethod.GET)
    public String createForm() {
        return "member/createForm";
    }

    @RequestMapping(value = "create", method = RequestMethod.POST)
    public String create(@Validated Member member, BindingResult bindingResult,
            RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            return "member/createForm";
        }
        Member createdMember = memberService.create(member);
        redirectAttributes.addFlashAttribute(createdMember);
        return "redirect:/members/create?complete";
    }

    @RequestMapping(value = "create", method = RequestMethod.GET, params = "complete")
    public String createComplete() {
        return "member/createComplete";
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleException(Exception e) {

        ModelMap models = new ModelMap();
        models.addAttribute("exceptionClassName", e.getClass().getName());
        models.addAttribute("exception", e);

        return new ModelAndView("member/error", models);
    }
}

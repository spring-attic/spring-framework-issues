package it.nibbles.test.controllers;

import it.nibbles.test.exceptions.UserNotFoundException;
import it.nibbles.test.objs.User;
import it.nibbles.test.services.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author Alessandro Polverini
 */
@Controller
@Transactional
public class TestController {

    @Autowired
    private TestService testService;

    @RequestMapping("/newUser/{name}")
    @ResponseBody
    public Object testNewUser(@PathVariable String name) {
        User user;
        try {
            user = testService.findUser(name);
            return "Existing User id: " + user.getId();
        } catch (UserNotFoundException ex) {
        }
        user = new User();
        user.setName(name);
        testService.save(user);
        return "New User id: " + user.getId();
    }

}

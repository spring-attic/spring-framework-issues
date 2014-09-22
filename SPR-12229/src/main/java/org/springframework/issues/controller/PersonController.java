package org.springframework.issues.controller;

import org.springframework.issues.tutorial.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonController {

    @RequestMapping("/")
    Person hello() {
        Person john =
                Person.newBuilder()
                        .setId(1234)
                        .setName("John Doe")
                        .setEmail("jdoe@example.com")
                        .addPhone(
                                Person.PhoneNumber.newBuilder()
                                        .setNumber("555-4321")
                                        .setType(Person.PhoneType.HOME))
                        .build();
        return john;
    }
}

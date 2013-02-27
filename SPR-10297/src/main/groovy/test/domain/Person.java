package test.domain;


import org.springframework.beans.factory.annotation.Configurable;

import test.service.PersonService;


@Configurable("person")
public class Person {

    private String firstName;

    private String lastName;

    private PersonService serviceField;

    public Person() {
    }

    public Person(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setService(PersonService service) {
        this.serviceField = service;
    }

    public PersonService getService() {
        return serviceField;
    }
}

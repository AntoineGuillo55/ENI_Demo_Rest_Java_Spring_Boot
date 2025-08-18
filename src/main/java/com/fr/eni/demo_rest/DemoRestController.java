package com.fr.eni.demo_rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


class Person {

    public String pseudo = "Toto";
}

@RestController
public class DemoRestController {

    @GetMapping("api/demo")
    Person ijzkehfzefsjf(){

        Person person = new Person();
        return person;
    }
}

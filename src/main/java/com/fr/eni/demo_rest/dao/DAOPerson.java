package com.fr.eni.demo_rest.dao;

import com.fr.eni.demo_rest.bo.Person;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Component
public class DAOPerson {

    public List<Person> DB_Persons;

    public DAOPerson() {

        DB_Persons = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.pseudo = String.format("pseudo-%d", i);
            p.age = 15 + i;

            DB_Persons.add(p);
        }
    }

    public List<Person> selectAll() {
        return DB_Persons;
    }
}

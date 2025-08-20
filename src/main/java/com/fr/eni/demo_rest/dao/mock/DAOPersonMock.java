package com.fr.eni.demo_rest.dao.mock;

import com.fr.eni.demo_rest.bo.Person;
import com.fr.eni.demo_rest.dao.IDAOPerson;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@Profile("mock")
public class DAOPersonMock implements IDAOPerson {

    public List<Person> DB_Persons;

    public DAOPersonMock() {

        DB_Persons = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.pseudo = String.format("pseudo-%d", i);
            p.age = 15 + i;

            DB_Persons.add(p);
        }
    }

    @Override
    public List<Person> selectAll() {
        return DB_Persons;
    }
}

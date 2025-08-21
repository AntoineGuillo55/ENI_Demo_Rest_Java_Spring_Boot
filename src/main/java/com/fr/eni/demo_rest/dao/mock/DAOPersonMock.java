package com.fr.eni.demo_rest.dao.mock;

import com.fr.eni.demo_rest.bo.Person;
import com.fr.eni.demo_rest.dao.IDAOPerson;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
@Profile("mock")
public class DAOPersonMock implements IDAOPerson {

    public List<Person> DB_Persons;

    public DAOPersonMock() {

        DB_Persons = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Person p = new Person();
            p.id = String.valueOf(i + 1);
            p.pseudo = String.format("pseudo-%d", i + 1);
            p.age = 15 + i;
            p.email = String.format("email-%d@gmail.com", i + 1);
            p.password = String.format("password-%d", i + 1);

            DB_Persons.add(p);
        }
    }

    @Override
    public List<Person> selectAll() {
        return DB_Persons;
    }

    @Override
    public Person selectPersonByLogin(String email, String password) {

        Optional<Person> foundPerson = DB_Persons.stream().filter(person -> person.email.equals(email) && person.password.equals(password)).findFirst();

        return foundPerson.orElse(null);
    }
}

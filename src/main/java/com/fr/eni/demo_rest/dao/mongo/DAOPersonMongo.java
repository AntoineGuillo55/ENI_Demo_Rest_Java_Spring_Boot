package com.fr.eni.demo_rest.dao.mongo;

import com.fr.eni.demo_rest.bo.Person;
import com.fr.eni.demo_rest.dao.IDAOPerson;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Profile("mongo")
public class DAOPersonMongo implements IDAOPerson {

    private final PersonMongoRepository repository;

    public DAOPersonMongo(PersonMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Person> selectAll() {
        return repository.findAll();
    }

    @Override
    public Person selectPersonByLogin(String email, String password) {
        return repository.findByEmailAndPassword(email, password);
    }
}

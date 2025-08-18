package com.fr.eni.demo_rest.service;

import com.fr.eni.demo_rest.bo.Person;
import com.fr.eni.demo_rest.dao.DAOPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceV2 {

    @Autowired
    private DAOPerson daoPerson;


    public ServiceResponse<List<Person>> displayOffAgePersons() {

        ServiceResponse<List<Person>> serviceResponse = new ServiceResponse<>();

        List<Person> results =  daoPerson.selectAll();

        results = results.stream().filter(person -> person.age >= 18).toList();

        serviceResponse.code = "2889";
        serviceResponse.data = results;

        return serviceResponse;
    }
}

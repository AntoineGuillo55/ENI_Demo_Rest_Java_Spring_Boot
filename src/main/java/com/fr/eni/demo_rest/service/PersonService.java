package com.fr.eni.demo_rest.service;

import com.fr.eni.demo_rest.bo.Person;
import com.fr.eni.demo_rest.dao.DAOPerson;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {


    private final DAOPerson daoPerson;

    public PersonService(DAOPerson daoPerson) {
        this.daoPerson = daoPerson;
    }

    /**
     * @deprecated displayOffAgePerson est dépréciée, veuillez utiliser {@link PersonServiceV2#displayOffAgePersons()}
     * @return
     */
    public List<Person> displayOffAgePersons() {

        //NE PAS FAIRE
        //DAOPerson DAOPerson = new DAOPerson();
        //Personnes ayant au moins 18 ans
        List<Person> results =  daoPerson.selectAll();

        //on ne garge que les personnes ayant plus de 18 ans
        results = results.stream().filter(person -> person.age >= 18).toList();

        return results;
    }
}

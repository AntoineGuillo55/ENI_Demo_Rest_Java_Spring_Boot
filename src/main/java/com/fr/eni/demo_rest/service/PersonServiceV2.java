package com.fr.eni.demo_rest.service;

import com.fr.eni.demo_rest.bo.Person;
import com.fr.eni.demo_rest.dao.DAOPerson;
import com.fr.eni.demo_rest.locale.LocaleHelper;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonServiceV2 {


    private final DAOPerson daoPerson;

    private final LocaleHelper localeHelper;

    public PersonServiceV2(DAOPerson daoPerson,  LocaleHelper localeHelper) {
        this.daoPerson = daoPerson;
        this.localeHelper = localeHelper;
    }

    public ServiceResponse<List<Person>> displayOffAgePersons() {

        ServiceResponse<List<Person>> serviceResponse = new ServiceResponse<>();

        List<Person> results =  daoPerson.selectAll();

        String message3 = localeHelper.i18n("DisplayOffAgePersons_200_Success");
        System.out.println("Test traduction");

        results = results.stream().filter(person -> person.age >= 18).toList();

        serviceResponse.code = "202";
        serviceResponse.message = message3;
        serviceResponse.data = results;

        return serviceResponse;
    }
}

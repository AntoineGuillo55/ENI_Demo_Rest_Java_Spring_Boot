package com.fr.eni.demo_rest.service;

import com.fr.eni.demo_rest.bo.Person;
import com.fr.eni.demo_rest.dao.DAOPerson;
import com.fr.eni.demo_rest.locale.LocaleHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class PersonServiceV2 {

    @Autowired
    private DAOPerson daoPerson;

    @Autowired
    MessageSource messageSource;

    @Autowired
    LocaleHelper localeHelper;


    public ServiceResponse<List<Person>> displayOffAgePersons() {

        ServiceResponse<List<Person>> serviceResponse = new ServiceResponse<>();

        List<Person> results =  daoPerson.selectAll();

//        String message = messageSource.getMessage("DisplayOffAgePersons_200_Success", null, LocaleContextHolder.getLocale());
//        String message2 = messageSource.getMessage("DisplayOffAgePersons_200_Success", null, Locale.ENGLISH);
        String message3 = localeHelper.i18n("DisplayOffAgePersons_200_Success");
        System.out.println("Test traduction");

        results = results.stream().filter(person -> person.age >= 18).toList();

        serviceResponse.code = "202";
        serviceResponse.message = message3;
        serviceResponse.data = results;

        return serviceResponse;
    }
}

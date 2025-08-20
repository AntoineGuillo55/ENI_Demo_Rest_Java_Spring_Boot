package com.fr.eni.demo_rest.dao;

import com.fr.eni.demo_rest.bo.Person;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IDAOPerson {

    List<Person> selectAll();
}

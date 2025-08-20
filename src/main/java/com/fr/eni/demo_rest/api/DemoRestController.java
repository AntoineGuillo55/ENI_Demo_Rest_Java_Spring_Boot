package com.fr.eni.demo_rest.api;

import com.fr.eni.demo_rest.bo.Person;
import com.fr.eni.demo_rest.service.PersonService;
import com.fr.eni.demo_rest.service.PersonServiceV2;
import com.fr.eni.demo_rest.service.ServiceResponse;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class DemoRestController {

    @Autowired
    private PersonService personService;

    @Autowired
    private PersonServiceV2 personServiceV2;

    @GetMapping("api/demo")
    Person ijzkehfzefsjf(){

        Person person = new Person();
        return person;
    }

    @Operation(summary = "Endpoint pour récupérer la liste des personnes majeures (déprécié)")
    @GetMapping("api/display-off-age-persons")
    public List<Person> apiDisplayOffAgePersons() {
        //Appeler le service pour récupérer les personnes majeurs
        List<Person> persons = personService.displayOffAgePersons();
        //Retourner le json du service
        return persons;

    }

    @Operation(summary = "Endpoint pour récupérer la liste des personnes majeures")
    @GetMapping("api/v2/display-off-age-persons")
    public ServiceResponse<List<Person>> apiDisplayOffAgePersonsV2() {
        //Appeler le service pour récupérer les personnes majeurs
        ServiceResponse<List<Person>> serviceResponse = personServiceV2.displayOffAgePersons();
        //Retourner le json du service
        return serviceResponse;

    }
}

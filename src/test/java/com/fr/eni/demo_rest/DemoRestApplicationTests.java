package com.fr.eni.demo_rest;

import com.fr.eni.demo_rest.bo.Person;
import com.fr.eni.demo_rest.service.PersonServiceV2;
import com.fr.eni.demo_rest.service.ServiceResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@SpringBootTest
class DemoRestApplicationTests {

    @Autowired
    PersonServiceV2 psV2;

	@Test
	void contextLoads() {
	}

    @Test
    void displayOffAgePersons_test(){

        ServiceResponse<List<Person>> result_1 = psV2.displayOffAgePersons();

        assertThat(result_1.code).isEqualTo("202");
    }
}

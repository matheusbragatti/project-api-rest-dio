package com.matheushdb.projectapirestdio.service;

import com.matheushdb.projectapirestdio.dto.request.PersonDTO;
import com.matheushdb.projectapirestdio.entity.Person;
import com.matheushdb.projectapirestdio.repository.PersonRepository;
import com.matheushdb.projectapirestdio.utils.PersonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO testPersonDTO = PersonUtils.createMockPersonDTO();
        Person testPerson = PersonUtils.createMockPerson();


        Mockito.when(personRepository.save(any(Person.class))).thenReturn(testPerson);

        Long successMessage = personService.createPerson(testPersonDTO);

        Assertions.assertEquals(testPerson.getId(),successMessage);
    }
}

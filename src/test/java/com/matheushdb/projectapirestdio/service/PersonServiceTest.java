package com.matheushdb.projectapirestdio.service;

import com.matheushdb.projectapirestdio.dto.request.PersonDTO;
import com.matheushdb.projectapirestdio.entity.Person;
import com.matheushdb.projectapirestdio.exception.PersonNotFoundException;
import com.matheushdb.projectapirestdio.repository.PersonRepository;
import com.matheushdb.projectapirestdio.utils.PersonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    //createPerson
    @Test
    void testGivenPersonDTOThenReturnSavedMessage() {
        PersonDTO testPersonDTO = PersonUtils.createMockPersonDTO();
        Person testPerson = PersonUtils.createMockPerson();

        Mockito.when(personRepository.save(any(Person.class))).thenReturn(testPerson);

        Long successMessage = personService.createPerson(testPersonDTO);

        Assertions.assertEquals(testPerson.getId(),successMessage);
    }

    //listAllPerson
    @Test
    void testGivenListPersonDTOThenReturnListPersonDTO(){
        List<Person> testListPerson = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            Person testPerson = PersonUtils.createMockPerson();
            testPerson.setId(Long.valueOf(i));
            testListPerson.add(testPerson);
        }
        Mockito.when(personRepository.findAll()).thenReturn(testListPerson);

        List<PersonDTO> successMessage = personService.listAll();

        Assertions.assertEquals(testListPerson.size(),successMessage.size());
        Assertions.assertEquals(testListPerson.get(0).getId(), successMessage.get(0).getId());
    }

    //findByIdPerson
    @Test
    void testGivenPersonIdThenReturnPerson() throws PersonNotFoundException {
        Person testPerson = PersonUtils.createMockPerson();
        PersonDTO testPersonDTO = PersonUtils.createMockPersonDTO();

        Mockito.when(personRepository.findById(1L)).thenReturn(java.util.Optional.of(testPerson));

        PersonDTO personToCompare = personService.findById(1L);

        Assertions.assertEquals(testPersonDTO,personToCompare);
    }

    //updatePerson
    @Test
    void testGivenPersonThenReturnUpdatedPerson() throws PersonNotFoundException {
        Person testPerson = PersonUtils.createMockPerson();
        PersonDTO testPersonDTO = PersonUtils.createMockPersonDTO();
        testPersonDTO.setFirstName("test");

        Mockito.when(personRepository.findById(1L)).thenReturn(java.util.Optional.of(testPerson));
        Mockito.when(personRepository.save(any(Person.class))).thenReturn(testPerson);

        String successMessage = personService.updateById(1L,testPersonDTO);

        Assertions.assertEquals(testPerson.getId(),Long.valueOf(successMessage));

    }
}

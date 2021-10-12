package com.matheushdb.projectapirestdio.service;

import com.matheushdb.projectapirestdio.dto.request.PersonDTO;
import com.matheushdb.projectapirestdio.entity.Person;
import com.matheushdb.projectapirestdio.exception.PersonNotFoundException;
import com.matheushdb.projectapirestdio.mapper.PersonMapper;
import com.matheushdb.projectapirestdio.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonService {

    private final PersonMapper personMapper = PersonMapper.INSTANCE;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    private PersonRepository personRepository;


    public Long createPerson(PersonDTO person){

        Person personToSave = personMapper.toModel(person);
        Person result = personRepository.save(personToSave);

        PersonDTO resultSet = PersonMapper.INSTANCE.toDTO(result);

        return result.getId();
    }


    public List<PersonDTO> listAll() {

        List<Person> personList = personRepository.findAll();

        return personList.stream().map(personMapper::toDTO).collect(Collectors.toList());
    }

    public PersonDTO findById(Long id) throws PersonNotFoundException {
        Person result = verifyIfExists(id);
        PersonDTO returnValue = personMapper.toDTO(result);
        return returnValue;
    }

    public void delete(Long id) throws PersonNotFoundException {
        Person personToDelete = verifyIfExists(id);
        personRepository.deleteById(id);

    }

    private Person verifyIfExists(Long id) throws PersonNotFoundException {
        return personRepository.findById(id).orElseThrow(() -> new PersonNotFoundException(id));
    }

    public String updateById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
        verifyIfExists(id);

        Person personToUpdate = personMapper.toModel(personDTO);
        Person personUpdated = personRepository.save(personToUpdate);

        return personUpdated.getId().toString();
    }
}

package com.matheushdb.projectapirestdio.controller;

import com.matheushdb.projectapirestdio.dto.request.PersonDTO;
import com.matheushdb.projectapirestdio.exception.PersonNotFoundException;
import com.matheushdb.projectapirestdio.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    private PersonService personService;

    @GetMapping
    public String homePage(){

        return "Person API";
    }

    @GetMapping("/get")
    public List<PersonDTO> listAll(){

        return personService.listAll();
    }

    @GetMapping("/get/{id}")
    public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {

        return personService.findById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createPerson(@RequestBody PersonDTO person){

        Long newId = personService.createPerson(person);
        String result = "New person created with ID= " + newId;

        return result;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws PersonNotFoundException{
        personService.delete(id);
    }

    @PutMapping("/update/{id}")
    public String updateById(@PathVariable Long id, @RequestBody PersonDTO personDTO) throws PersonNotFoundException {

        return personService.updateById(id, personDTO);
    }
}

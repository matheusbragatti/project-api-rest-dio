package com.matheushdb.projectapirestdio.utils;

import com.matheushdb.projectapirestdio.dto.request.PersonDTO;
import com.matheushdb.projectapirestdio.entity.Person;
import com.matheushdb.projectapirestdio.entity.Phone;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PersonUtils {

    public static PersonDTO createMockPersonDTO(){
        PersonDTO newPerson = new PersonDTO();
        newPerson.setId(1L);
        newPerson.setFirstName("Matheus");
        newPerson.setLastName("Henrique");
        newPerson.setCpf("123");
        newPerson.setBirthDate(LocalDate.now());

        Phone newPhone = new Phone();
        newPhone.setId(1L);
        newPhone.setNumber("123");
        newPhone.setType("mobile");

        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(newPhone);

        newPerson.setPhoneDTOList(phoneList);

        return newPerson;
    }

    public static Person createMockPerson(){
        Person newPerson = new Person();
        newPerson.setId(1L);
        newPerson.setFirstName("Matheus");
        newPerson.setLastName("Henrique");
        newPerson.setCpf("123");
        newPerson.setBirthDate(LocalDate.now());

        Phone newPhone = new Phone();
        newPhone.setId(1L);
        newPhone.setNumber("123");
        newPhone.setType("mobile");

        List<Phone> phoneList = new ArrayList<>();
        phoneList.add(newPhone);

        newPerson.setPhoneList(phoneList);

        return newPerson;
    }

}

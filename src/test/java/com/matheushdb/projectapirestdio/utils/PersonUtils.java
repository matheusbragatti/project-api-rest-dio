package com.matheushdb.projectapirestdio.utils;

import com.matheushdb.projectapirestdio.dto.request.BillDTO;
import com.matheushdb.projectapirestdio.dto.request.PersonDTO;
import com.matheushdb.projectapirestdio.dto.request.PhoneDTO;
import com.matheushdb.projectapirestdio.entity.Bill;
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

        PhoneDTO newPhone = new PhoneDTO();
        newPhone.setId(1L);
        newPhone.setNumber("123");
        newPhone.setType("mobile");

        List<PhoneDTO> phoneList = new ArrayList<>();
        phoneList.add(newPhone);

        newPerson.setPhoneList(phoneList);

        BillDTO newBill = new BillDTO();
        newBill.setBillName("Streaming x");
        newBill.setBillValue(21L);
        newBill.setId(1L);

        List<BillDTO> billList = new ArrayList<>();
        billList.add(newBill);

        newPerson.setBillList(billList);

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

        Bill newBill = new Bill();
        newBill.setBillName("Streaming x");
        newBill.setBillValue(21L);
        newBill.setId(1L);

        List<Bill> billList = new ArrayList<>();
        billList.add(newBill);

        newPerson.setBillList(billList);

        return newPerson;
    }

}

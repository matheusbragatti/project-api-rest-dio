package com.matheushdb.projectapirestdio.service;

import com.matheushdb.projectapirestdio.dto.request.BillDTO;
import com.matheushdb.projectapirestdio.dto.request.PersonDTO;
import com.matheushdb.projectapirestdio.entity.Bill;
import com.matheushdb.projectapirestdio.entity.Person;
import com.matheushdb.projectapirestdio.exception.BillNotFoundException;
import com.matheushdb.projectapirestdio.exception.PersonNotFoundException;
import com.matheushdb.projectapirestdio.mapper.BillMapper;
import com.matheushdb.projectapirestdio.mapper.PersonMapper;
import com.matheushdb.projectapirestdio.repository.BillRepository;
import com.matheushdb.projectapirestdio.repository.PersonRepository;
import com.matheushdb.projectapirestdio.utils.BillUtils;
import com.matheushdb.projectapirestdio.utils.PersonUtils;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
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
public class BillServiceTest {
    private final BillMapper billMapper = BillMapper.INSTANCE;

    @Mock
    private BillRepository billRepository;

    @InjectMocks
    private BillService billService;

    @Mock
    private PersonRepository personRepository;

    @Mock
    private PersonService personService;

    //listAll
    @Test
    void testGivenBillListThenReturnBillListDTO(){
        List<Bill> testListBill = new ArrayList<>();
        for (int i = 1; i <= 3; i++){
            Bill testBill = BillUtils.createMockBill();
            testBill.setId(Long.valueOf(i));
            testListBill.add(testBill);
        }

        Mockito.when(billRepository.findAll()).thenReturn(testListBill);

        List<BillDTO> testService = billService.listAll();

;

        Assertions.assertEquals(testListBill.size(), testService.size());
        Assertions.assertEquals(testListBill.get(0).getId(), testService.get(0).getId());
    }

    //findById
    @Test
    void testGivenBillIdThenReturnBill() throws BillNotFoundException {
        Bill testBill = BillUtils.createMockBill();
        BillDTO testBillDTO = BillUtils.createMockBillDTO();

        Mockito.when(billRepository.findById(1L)).thenReturn(java.util.Optional.of(testBill));

        BillDTO testService = billService.findById(1L);

        Assertions.assertEquals(testBillDTO,testService);
    }


    //findByUserId
    @Test
    void testGivenPersonIdThenReturnBillList() throws PersonNotFoundException {
        Person testPerson = PersonUtils.createMockPerson();
        PersonDTO testPersonDTO = PersonUtils.createMockPersonDTO();

        Mockito.when(personService.findById(1L)).thenReturn(testPersonDTO);

        List<BillDTO> testService = billService.findByUserId(1L);

        Assertions.assertEquals(testService.get(0).getBillName(), testPerson.getBillList().get(0).getBillName());
    }

    //totalBillByUserId
    @Test
    void testGivenPersonIdThenReturnTotalAmount() throws PersonNotFoundException {
        Bill testBill = BillUtils.createMockBill();
        Person testPerson = PersonUtils.createMockPerson();
        testPerson.getBillList().add(testBill);
        PersonDTO testPersonDTO = PersonUtils.createMockPersonDTO();

        Mockito.when(personService.findById(1L)).thenReturn(testPersonDTO);

        Long testService = billService.getTotalBillByUserId(1L);

        Assertions.assertEquals(testService, testPerson.getBillList().get(0).getBillValue());
    }

    //updateBill
    @Test
    void testGivenBillThenReturnUpdatedBill() throws BillNotFoundException {
        Bill testBill = BillUtils.createMockBill();
        BillDTO testBillDTO = BillUtils.createMockBillDTO();
        testBillDTO.setBillName("test");

        Mockito.when(billRepository.findById(1L)).thenReturn(java.util.Optional.of(testBill));
        Mockito.when(billRepository.save(any(Bill.class))).thenReturn(testBill);

        String testService = billService.updateById(1L, testBillDTO);

        Assertions.assertEquals(testBill.getId().toString(), testService);
    }
}

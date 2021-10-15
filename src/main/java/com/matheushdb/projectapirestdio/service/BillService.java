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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BillService {

    private final BillMapper billMapper = BillMapper.INSTANCE;

    @Autowired
    public BillService(BillRepository billRepository, PersonService personService) {
        this.billRepository = billRepository; this.personService = personService;
    }

    private BillRepository billRepository;

    private PersonService personService;


    public String createBill(BillDTO billDTO) {

        Bill billToSave = billMapper.toModel(billDTO);
        Bill result = billRepository.save(billToSave);

        return "Bill saved with ID: " + result.getId();
    }

    public List<BillDTO> listAll() {

        List<Bill> billList = billRepository.findAll();

        return billList.stream().map(billMapper::toDTO).collect(Collectors.toList());
    }

    public BillDTO findById(Long id) throws BillNotFoundException {
        Bill result = verifyIfExists(id);
        BillDTO returnValue = billMapper.toDTO(result);

        return returnValue;
    }

    public void delete(Long id) throws BillNotFoundException{
        Bill billToDelete = verifyIfExists(id);
        billRepository.deleteById(id);
    }

    public String updateById(Long id, BillDTO personDTO) throws BillNotFoundException {
        verifyIfExists(id);

        Bill billToUpdate = billMapper.toModel(personDTO);
        Bill billUpdated = billRepository.save(billToUpdate);

        return billUpdated.getId().toString();
    }

    public List<BillDTO> findByUserId(Long id) throws PersonNotFoundException {

        PersonDTO personDTO = personService.findById(id);


        return personDTO.getBillList();
    }

    public Long getTotalBillByUserId(Long id) throws PersonNotFoundException {

        PersonDTO personDTO = personService.findById(id);
        Long total = 0L;

        for (BillDTO bill: personDTO.getBillList()) {
            total += bill.getBillValue();
        }

        return total;
    }

    private Bill verifyIfExists(Long id) throws BillNotFoundException {
        return billRepository.findById(id).orElseThrow(() -> new BillNotFoundException(id));
    }
}

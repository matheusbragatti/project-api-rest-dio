package com.matheushdb.projectapirestdio.controller;


import com.matheushdb.projectapirestdio.dto.request.BillDTO;
import com.matheushdb.projectapirestdio.exception.BillNotFoundException;
import com.matheushdb.projectapirestdio.exception.PersonNotFoundException;
import com.matheushdb.projectapirestdio.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bill")
public class BillController {

    @Autowired
    public BillController(BillService billService) {
        this.billService = billService;
    }

    private BillService billService;

    @GetMapping()
    public String billHomePage(){

        return "Bill home page";
    }


    @GetMapping("/get")
    public List<BillDTO> listAll(){

        return billService.listAll();
    }

    @GetMapping("/get/{id}")
    public BillDTO findById(@PathVariable Long id) throws BillNotFoundException {

        return billService.findById(id);
    }

    @GetMapping("/user/{id}")
    public List<BillDTO> getByUserId(@PathVariable Long id) throws PersonNotFoundException {

        List<BillDTO> byUserId = billService.findByUserId(id);
        return byUserId;
    }

    @GetMapping("/user/total/{id}")
    public String getTotalBillByUserId(@PathVariable Long id) throws PersonNotFoundException {

        Long total = billService.getTotalBillByUserId(id);

        return "Total amount = " + total;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String createBill(@RequestBody BillDTO billDTO){
        String result = billService.createBill(billDTO);

        return result;
    }

    @DeleteMapping("/delete/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) throws BillNotFoundException {
        billService.delete(id);
    }

    @PutMapping("/update/{id}")
    public String updateById(@PathVariable Long id, @RequestBody BillDTO billDTO) throws BillNotFoundException {

        return billService.updateById(id, billDTO);
    }

}

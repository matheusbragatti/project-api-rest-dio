package com.matheushdb.projectapirestdio.utils;

import com.matheushdb.projectapirestdio.dto.request.BillDTO;
import com.matheushdb.projectapirestdio.entity.Bill;

public class BillUtils {

    public static Bill createMockBill(){
        Bill newBill = new Bill();
        newBill.setBillName("Streaming x");
        newBill.setBillValue(21L);
        newBill.setId(1L);

        return newBill;
    }

    public static BillDTO createMockBillDTO(){
        BillDTO newBillDTO = new BillDTO();

        newBillDTO.setBillName("Streaming x");
        newBillDTO.setBillValue(21L);
        newBillDTO.setId(1L);

        return newBillDTO;
    }
}

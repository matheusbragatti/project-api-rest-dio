package com.matheushdb.projectapirestdio.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BillNotFoundException extends Exception {
    public BillNotFoundException(Long id) {
        super("Bill not found with ID: " + id);
    }
}

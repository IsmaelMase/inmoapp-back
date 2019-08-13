package com.inmboapp.clients.controller;

import com.inmboapp.clients.model.exception.ClientDniAlReadyExist;
import com.inmboapp.clients.model.exception.ClientNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(ClientNotFound.class)
    private ResponseEntity realtorNotFound(ClientNotFound ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ClientDniAlReadyExist.class)
    private ResponseEntity realEstateNotFound(ClientDniAlReadyExist ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}

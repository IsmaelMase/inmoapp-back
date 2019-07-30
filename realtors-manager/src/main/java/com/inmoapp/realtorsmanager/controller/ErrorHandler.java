package com.inmoapp.realtorsmanager.controller;

import com.inmoapp.realtorsmanager.model.exception.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(RealtorNotFound.class)
    private ResponseEntity realtorNotFound(RealtorNotFound ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RealEstateNotFound.class)
    private ResponseEntity realEstateNotFound(RealEstateNotFound ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RealtorNicknameAlReadyExist.class)
    private ResponseEntity realtorNicknameAlReadyExist(RealtorNicknameAlReadyExist ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(RealtorEmailAlReadyExist.class)
    private ResponseEntity realtorEmailAlReadyExist(RealtorEmailAlReadyExist ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.CONFLICT);
    }
}


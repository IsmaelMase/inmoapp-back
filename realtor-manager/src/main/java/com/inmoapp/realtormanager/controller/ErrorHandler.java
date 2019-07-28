package com.inmoapp.usercomponent.controller;

import com.inmoapp.usercomponent.model.exception.UserNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(UserNotFound.class)
    private ResponseEntity userNotFoundException(UserNotFound ex) {
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }


}


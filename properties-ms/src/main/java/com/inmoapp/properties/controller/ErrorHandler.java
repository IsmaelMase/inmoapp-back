package com.inmoapp.properties.controller;

import com.inmoapp.properties.model.exception.PropertyByCodRefNotFound;
import com.inmoapp.properties.model.exception.PropertyByIdNotFound;
import com.inmoapp.properties.model.exception.PropertyCodRefAlReadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {
    @ExceptionHandler(PropertyByIdNotFound.class)
    private ResponseEntity propertyByIdNotFound(PropertyByIdNotFound ex){
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PropertyByCodRefNotFound.class)
    private ResponseEntity propertyByCodRefNotFound(PropertyByCodRefNotFound ex){
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(PropertyCodRefAlReadyExists.class)
    private ResponseEntity propertyByCodRefAlReadyExists(PropertyCodRefAlReadyExists ex){
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}

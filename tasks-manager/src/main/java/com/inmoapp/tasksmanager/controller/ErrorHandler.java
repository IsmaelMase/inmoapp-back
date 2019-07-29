package com.inmoapp.tasksmanager.controller;

import com.inmoapp.tasksmanager.model.exception.RealtorNotFound;
import com.inmoapp.tasksmanager.model.exception.TaskNotFound;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(TaskNotFound.class)
    private ResponseEntity taskNotFound(TaskNotFound ex){
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(RealtorNotFound.class)
    private ResponseEntity realtorNotFound(RealtorNotFound ex){
        return new ResponseEntity(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

}

package com.inmoapp.realtormanager.model.exception;

public class RealtorNotFoundException extends RuntimeException {
    public RealtorNotFoundException(String realtorId) {
        super("The user with id " + realtorId + " not found");
    }
}

package com.inmoapp.realtormanager.model.exception;

public class RequiredFields extends RuntimeException {
    public RequiredFields(String message) {
        super(message);
    }
}

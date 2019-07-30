package com.inmoapp.realtorsmanager.model.exception;

public class RequiredFields extends RuntimeException {
    public RequiredFields(String message) {
        super(message);
    }
}

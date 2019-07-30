package com.inmoapp.realtors.model.exception;

public class RequiredFields extends RuntimeException {
    public RequiredFields(String message) {
        super(message);
    }
}

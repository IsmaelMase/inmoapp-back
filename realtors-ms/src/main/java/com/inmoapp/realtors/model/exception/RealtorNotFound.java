package com.inmoapp.realtors.model.exception;

public class RealtorNotFound extends RuntimeException {
    public RealtorNotFound(String realtorId) {
        super("The user with id " + realtorId + " not found");
    }
}

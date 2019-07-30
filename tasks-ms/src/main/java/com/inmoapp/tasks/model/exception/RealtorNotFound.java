package com.inmoapp.tasks.model.exception;

public class RealtorNotFound extends RuntimeException {
    public RealtorNotFound(String realtorId) {
        super("The realtor with id "+realtorId+" not exsist");
    }
}

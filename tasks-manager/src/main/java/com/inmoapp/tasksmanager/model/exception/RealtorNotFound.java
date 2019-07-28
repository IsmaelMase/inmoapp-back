package com.inmoapp.tasksmanager.model.exception;

public class RealtorNotFound extends RuntimeException {
    public RealtorNotFound(String realtorId) {
        super("The realtor with id "+realtorId+" not exsist");
    }
}

package com.inmoapp.realtormanager.model.exception;

public class RealEstateNotFound extends RuntimeException {
    public RealEstateNotFound(String realEstateId) {
        super("The real estate with id "+realEstateId+" not found");
    }
}

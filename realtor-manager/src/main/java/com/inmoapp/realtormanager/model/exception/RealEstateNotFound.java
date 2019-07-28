package com.inmoapp.realtormanager.model.exception;

public class RealEstateNotFoundException extends RuntimeException {
    public RealEstateNotFoundException(String realEstateId) {
        super("The real estate with id "+realEstateId+" not found");
    }
}

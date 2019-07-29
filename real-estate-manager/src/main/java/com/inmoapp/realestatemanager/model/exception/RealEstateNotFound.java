package com.inmoapp.realestatemanager.model.exception;

public class RealEstateNotFound extends RuntimeException {
    public RealEstateNotFound(String realEstateId) {
        super("The real estate with id "+realEstateId+" not exist");
    }
}

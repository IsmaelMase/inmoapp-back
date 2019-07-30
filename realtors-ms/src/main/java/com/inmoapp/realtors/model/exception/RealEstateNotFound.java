package com.inmoapp.realtors.model.exception;

public class RealEstateNotFound extends RuntimeException {
    public RealEstateNotFound(String realEstateId) {
        super("The real estate with id "+realEstateId+" not found");
    }
}

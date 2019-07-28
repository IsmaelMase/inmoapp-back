package com.inmoapp.realestatemanager.model.exception;

public class RealEstateCifAlReadyExist extends RuntimeException {
    public RealEstateCifAlReadyExist() {
        super("There is a real estate with the same CIF");
    }
}

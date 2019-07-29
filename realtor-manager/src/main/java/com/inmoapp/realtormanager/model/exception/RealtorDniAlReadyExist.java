package com.inmoapp.realtormanager.model.exception;

public class RealtorDniAlReadyExist extends RuntimeException {
    public RealtorDniAlReadyExist() {
        super("There is a realtor with the same DNI");
    }
}


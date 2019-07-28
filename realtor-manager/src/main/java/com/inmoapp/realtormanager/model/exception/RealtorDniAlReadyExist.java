package com.inmoapp.realtormanager.model.exception;

public class RealtorAlReadyExist extends RuntimeException {
    public RealtorAlReadyExist() {
        super("There is a realtor wiht the same DNI");
    }
}


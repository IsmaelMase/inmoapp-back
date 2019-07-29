package com.inmoapp.realtormanager.model.exception;

public class RealtorEmailAlReadyExist extends RuntimeException {
    public RealtorEmailAlReadyExist() {
        super("There is a realtor with the same email");
    }
}

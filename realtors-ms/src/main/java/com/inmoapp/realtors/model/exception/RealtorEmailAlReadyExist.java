package com.inmoapp.realtors.model.exception;

public class RealtorEmailAlReadyExist extends RuntimeException {
    public RealtorEmailAlReadyExist() {
        super("There is a realtor with the same email");
    }
}

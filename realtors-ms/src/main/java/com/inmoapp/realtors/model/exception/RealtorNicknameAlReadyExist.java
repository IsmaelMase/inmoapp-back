package com.inmoapp.realtors.model.exception;

public class RealtorNicknameAlReadyExist extends RuntimeException {
    public RealtorNicknameAlReadyExist() {
        super("There is a realtor with the same nickname");
    }
}


package com.inmboapp.clients.model.exception;

public class ClientDniAlReadyExist extends RuntimeException {
    public ClientDniAlReadyExist(String dni) {
        super("There is a client with the dni: " + dni);
    }
}

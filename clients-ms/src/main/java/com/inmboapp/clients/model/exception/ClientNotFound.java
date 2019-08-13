package com.inmboapp.clients.model.exception;

public class ClientNotFound extends RuntimeException {
    public ClientNotFound(String clientId) {
        super("The client with id "+clientId+" not found");
    }

}

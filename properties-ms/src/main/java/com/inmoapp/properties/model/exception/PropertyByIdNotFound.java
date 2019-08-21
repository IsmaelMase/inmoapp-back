package com.inmoapp.properties.model.exception;

public class PropertyByIdNotFound extends RuntimeException {
    public PropertyByIdNotFound(String id) {
        super("Property with id:" + id + " not found");
    }
}

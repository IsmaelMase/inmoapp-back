package com.inmoapp.properties.model.exception;

public class PropertyByCodRefNotFound extends RuntimeException {
    public PropertyByCodRefNotFound(String codRef) {
        super("Property with id:" + codRef + " not found");
    }
}

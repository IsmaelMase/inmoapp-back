package com.inmoapp.properties.model.exception;

public class PropertyCodRefAlReadyExists extends RuntimeException {
    public PropertyCodRefAlReadyExists() {
        super("There is a property with the same codRef");
    }
}

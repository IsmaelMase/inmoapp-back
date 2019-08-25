package com.inmoapp.properties.service;

import com.inmoapp.properties.model.PropertyModel;

import java.util.Set;

public interface PropertyService {
    Set<PropertyModel> findAllProperties();

    PropertyModel findPropertyById(String id);

    PropertyModel findPropertyByCodRef(String codRef);

    PropertyModel addProperty(PropertyModel propertyModel, String realtorId);

    void removeProperty(String id);
}

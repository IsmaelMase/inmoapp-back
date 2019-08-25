package com.inmoapp.properties.service.impl;

import com.inmoapp.properties.client.TasksClient;
import com.inmoapp.properties.converter.PropertyEntityToPropertyModel;
import com.inmoapp.properties.converter.PropertyModelToPropertyEntity;
import com.inmoapp.properties.entity.PropertyEntity;
import com.inmoapp.properties.model.PropertyModel;
import com.inmoapp.properties.model.exception.PropertyByCodRefNotFound;
import com.inmoapp.properties.model.exception.PropertyByIdNotFound;
import com.inmoapp.properties.model.exception.PropertyCodRefAlReadyExists;
import com.inmoapp.properties.repository.PropertyRepository;
import com.inmoapp.properties.service.PropertyService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PropertyServiceImpl implements PropertyService {

    private final PropertyRepository propertyRepository;

    private final PropertyEntityToPropertyModel propertyEntityToPropertyModel;

    private final PropertyModelToPropertyEntity propertyModelToPropertyEntity;

    private final TasksClient tasksClient;

    public PropertyServiceImpl(PropertyRepository propertyRepository, PropertyEntityToPropertyModel propertyEntityToPropertyModel, PropertyModelToPropertyEntity propertyModelToPropertyEntity, TasksClient tasksClient) {
        this.propertyRepository = propertyRepository;
        this.propertyEntityToPropertyModel = propertyEntityToPropertyModel;
        this.propertyModelToPropertyEntity = propertyModelToPropertyEntity;
        this.tasksClient = tasksClient;
    }

    @Override
    public Set<PropertyModel> findAllProperties() {
        return propertyRepository.findAll().stream().map(propertyEntityToPropertyModel).collect(Collectors.toSet());
    }

    @Override
    public PropertyModel findPropertyById(String id) {
        return propertyRepository.findById(id).map(propertyEntityToPropertyModel).orElseThrow(() -> new PropertyByIdNotFound(id));
    }

    @Override
    public PropertyModel findPropertyByCodRef(String codRef) {
        return propertyRepository.findPropertyByCodRef(codRef).map(propertyEntityToPropertyModel).orElseThrow(() -> new PropertyByCodRefNotFound(codRef));
    }

    @Override
    public PropertyModel addProperty(PropertyModel propertyModel, String realtorId) {
        propertyModel.setId("");

        propertyExistByCodRef(propertyModel.getCodRef());

        PropertyEntity propertyEntity = propertyRepository.save(propertyModelToPropertyEntity.apply(propertyModel));

        tasksClient.saveInitTask(realtorId, propertyEntity.getId());

        return propertyEntityToPropertyModel.apply(propertyEntity);
    }

    @Override
    public void removeProperty(String id) {
        propertyRepository.deleteById(id);
    }

    public void propertyExistByCodRef(String codRef) {
        Optional<PropertyEntity> existByCodRef = propertyRepository.findPropertyByCodRef(codRef);
        if (existByCodRef.isPresent()) {
            throw new PropertyCodRefAlReadyExists();
        }
    }
}

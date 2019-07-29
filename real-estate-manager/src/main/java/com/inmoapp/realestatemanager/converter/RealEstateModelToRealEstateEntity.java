package com.inmoapp.realestatemanager.converter;

import com.inmoapp.realestatemanager.entity.RealEstateEntity;
import com.inmoapp.realestatemanager.model.RealEstateModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RealEstateModelToRealEstateEntity implements Function<RealEstateModel, RealEstateEntity> {

    @Override
    public RealEstateEntity apply(RealEstateModel realEstateModel) {
        return RealEstateEntity.builder()
                .id(!realEstateModel.getId().isEmpty() ? realEstateModel.getId() : null)
                .cif(realEstateModel.getCif())
                .name(realEstateModel.getName())
                .phoneContacte(realEstateModel.getPhoneContacte())
                .emailContact(realEstateModel.getEmailContact())
                .address(realEstateModel.getAddress()).build();
    }
}


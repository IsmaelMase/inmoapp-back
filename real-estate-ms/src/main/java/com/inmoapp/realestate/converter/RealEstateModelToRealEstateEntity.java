package com.inmoapp.realestate.converter;

import com.inmoapp.realestate.entity.RealEstateEntity;
import com.inmoapp.realestate.model.RealEstateModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RealEstateModelToRealEstateEntity implements Function<RealEstateModel, RealEstateEntity> {

    @Override
    public RealEstateEntity apply(RealEstateModel realEstateModel) {
        return RealEstateEntity.builder()
                .id(!realEstateModel.getId().isEmpty() ? realEstateModel.getId() : null)
                .name(realEstateModel.getName())
                .phoneContacte(realEstateModel.getPhoneContacte())
                .emailContact(realEstateModel.getEmailContact())
                .address(realEstateModel.getAddress()).build();
    }
}


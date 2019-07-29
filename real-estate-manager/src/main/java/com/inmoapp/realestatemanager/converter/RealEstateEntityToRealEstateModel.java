package com.inmoapp.realestatemanager.converter;

import com.inmoapp.realestatemanager.entity.RealEstateEntity;
import com.inmoapp.realestatemanager.model.RealEstateModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RealEstateEntityToRealEstateModel implements Function<RealEstateEntity, RealEstateModel> {

    @Override
    public RealEstateModel apply(RealEstateEntity realEstateEntity) {
        return RealEstateModel.builder()
                .id(realEstateEntity.getId())
                .cif(realEstateEntity.getCif())
                .name(realEstateEntity.getName())
                .phoneContacte(realEstateEntity.getPhoneContacte())
                .emailContact((realEstateEntity.getEmailContact()))
                .address(realEstateEntity.getAddress()).build();
    }

}

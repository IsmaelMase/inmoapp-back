package com.inmoapp.realestate.converter;

import com.inmoapp.realestate.entity.RealEstateEntity;
import com.inmoapp.realestate.model.RealEstateModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RealEstateEntityToRealEstateModel implements Function<RealEstateEntity, RealEstateModel> {

    @Override
    public RealEstateModel apply(RealEstateEntity realEstateEntity) {
        return RealEstateModel.builder()
                .id(realEstateEntity.getId())
                .name(realEstateEntity.getName())
                .phoneContacte(realEstateEntity.getPhoneContacte())
                .emailContact((realEstateEntity.getEmailContact()))
                .address(realEstateEntity.getAddress()).build();
    }

}

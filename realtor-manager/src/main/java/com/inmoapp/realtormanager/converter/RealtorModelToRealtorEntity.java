package com.inmoapp.realtormanager.converter;

import com.inmoapp.realtormanager.entity.RealtorEntity;
import com.inmoapp.realtormanager.model.RealtorModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RealtorModelToRealtorEntity implements Function<RealtorModel, RealtorEntity> {

    @Override
    public RealtorEntity apply(RealtorModel realtorModel) {
        return RealtorEntity.builder()
                .id(!realtorModel.getId().isEmpty() ? realtorModel.getId() : null)
                .dni(realtorModel.getDni())
                .emailContact(realtorModel.getEmailContact())
                .name(realtorModel.getName())
                .subname(realtorModel.getSubname())
                .role(realtorModel.getRole())
                .phoneContact(realtorModel.getPhoneContact())
                .realEstateId(realtorModel.getRealEstateId()).build();
    }
}

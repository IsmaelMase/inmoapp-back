package com.inmoapp.realtormanager.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.inmoapp.realtormanager.entity.RealtorEntity;
import com.inmoapp.realtormanager.model.RealtorModel;

@Component
public class RealtorEntityToRealtorModel implements Function<RealtorEntity, RealtorModel> {

    @Override
    public RealtorModel apply(RealtorEntity realtorEntity) {
        return RealtorModel.builder()
                .id(realtorEntity.getId())
                .dni(realtorEntity.getDni())
                .emailContact(realtorEntity.getEmailContact())
                .name(realtorEntity.getName())
                .subname(realtorEntity.getSubname())
                .role(realtorEntity.getRole())
                .phoneContact(realtorEntity.getPhoneContact())
                .realEstateId(realtorEntity.getRealEstateId()).build();
    }
}

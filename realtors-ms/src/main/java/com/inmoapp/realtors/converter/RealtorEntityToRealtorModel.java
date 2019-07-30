package com.inmoapp.realtors.converter;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import com.inmoapp.realtors.entity.RealtorEntity;
import com.inmoapp.realtors.model.RealtorModel;

@Component
public class RealtorEntityToRealtorModel implements Function<RealtorEntity, RealtorModel> {

    @Override
    public RealtorModel apply(RealtorEntity realtorEntity) {
        return RealtorModel.builder()
                .id(realtorEntity.getId())
                .nickname(realtorEntity.getNickname())
                .emailContact(realtorEntity.getEmailContact())
                .name(realtorEntity.getName())
                .subname(realtorEntity.getSubname())
                .role(realtorEntity.getRole())
                .phoneContact(realtorEntity.getPhoneContact())
                .realEstateId(realtorEntity.getRealEstateId()).build();
    }
}

package com.inmoapp.realtors.converter;

import com.inmoapp.realtors.entity.RealtorEntity;
import com.inmoapp.realtors.model.RealtorModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RealtorModelToRealtorEntity implements Function<RealtorModel, RealtorEntity> {

    @Override
    public RealtorEntity apply(RealtorModel realtorModel) {
        return RealtorEntity.builder()
                .id(!realtorModel.getId().isEmpty() ? realtorModel.getId() : null)
                .nickname(realtorModel.getNickname())
                .emailContact(realtorModel.getEmailContact())
                .name(realtorModel.getName())
                .subname(realtorModel.getSubname())
                .role(realtorModel.getRole())
                .phoneContact(realtorModel.getPhoneContact())
                .realEstateId(realtorModel.getRealEstateId()).build();
    }
}

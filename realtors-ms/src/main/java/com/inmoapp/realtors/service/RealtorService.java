package com.inmoapp.realtors.service;

import com.inmoapp.realtors.model.RealtorModel;

import java.util.Set;

public interface RealtorService {

    Set<RealtorModel> findAllRealtors();

    RealtorModel findRealtorById(String id);

    Set<RealtorModel> findRealtorsByRealEstateId(String realEstateId);

    RealtorModel addRealtor(RealtorModel realtor);

    RealtorModel updateRealtor(RealtorModel realtor);

    void removeRealtor(String id);

}

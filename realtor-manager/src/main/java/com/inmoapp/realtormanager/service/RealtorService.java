package com.inmoapp.realtormanager.service;

import com.inmoapp.realtormanager.model.RealtorModel;

import java.util.Set;

public interface RealtorService {

    Set<RealtorModel> findAllRealtors();

    RealtorModel findRealtorById(String id);

    Set<RealtorModel> findRealtorsByRealEstateId(String realEstateId);

    RealtorModel addRealtor(RealtorModel realtor);

    void removeRealtor(String id);

}

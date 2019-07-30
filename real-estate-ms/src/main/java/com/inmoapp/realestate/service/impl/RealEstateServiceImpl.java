package com.inmoapp.realestate.service.impl;

import com.inmoapp.realestate.converter.RealEstateEntityToRealEstateModel;
import com.inmoapp.realestate.converter.RealEstateModelToRealEstateEntity;
import com.inmoapp.realestate.entity.RealEstateEntity;
import com.inmoapp.realestate.model.RealEstateModel;
import com.inmoapp.realestate.model.exception.RealEstateNotFound;
import com.inmoapp.realestate.repository.RealEstateRepository;
import com.inmoapp.realestate.service.RealEstateService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class RealEstateServiceImpl implements RealEstateService {

    private final RealEstateRepository realEstateRepository;

    private final RealEstateEntityToRealEstateModel realEstateEntityToRealEstateModel;

    private final RealEstateModelToRealEstateEntity realEstateModelToRealEstateEntity;

    public RealEstateServiceImpl(RealEstateRepository realEstateRepository, RealEstateEntityToRealEstateModel realEstateEntityToRealEstateModel, RealEstateModelToRealEstateEntity realEstateModelToRealEstateEntity) {
        this.realEstateRepository = realEstateRepository;
        this.realEstateEntityToRealEstateModel = realEstateEntityToRealEstateModel;
        this.realEstateModelToRealEstateEntity = realEstateModelToRealEstateEntity;
    }

    public RealEstateModel findRealEstateById(String id) {
        return realEstateRepository.findById(id).map(realEstateEntityToRealEstateModel).orElseThrow(() -> new RealEstateNotFound(id));
    }

    public Set<RealEstateModel> findAllRealEstate() {
        return realEstateRepository.findAll().stream().map(realEstateEntityToRealEstateModel).collect(Collectors.toSet());

    }

    public RealEstateModel addRealEstate(RealEstateModel realEstateModel) {
        realEstateModel.setId("");

        RealEstateEntity realEstate = realEstateRepository.save(realEstateModelToRealEstateEntity.apply(realEstateModel));

        return realEstateEntityToRealEstateModel.apply(realEstate);
    }

    public RealEstateModel updateRealEstate(RealEstateModel realEstateModel) {

        existRealEstateById(realEstateModel.getId());

        RealEstateEntity realEstate = realEstateRepository.save(realEstateModelToRealEstateEntity.apply(realEstateModel));

        return realEstateEntityToRealEstateModel.apply(realEstate);
    }

    private void existRealEstateById(String id) {
        Optional<RealEstateEntity> realEstateById=realEstateRepository.findById(id);
        if(!realEstateById.isPresent()){
            throw new RealEstateNotFound(id);
        }
    }

    public void removeRealEstate(String id) {
        realEstateRepository.deleteById(id);
    }

}

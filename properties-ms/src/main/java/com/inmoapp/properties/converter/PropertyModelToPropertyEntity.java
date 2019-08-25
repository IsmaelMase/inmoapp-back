package com.inmoapp.properties.converter;

import com.inmoapp.properties.entity.PropertyEntity;
import com.inmoapp.properties.model.PropertyModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PropertyModelToPropertyEntity implements Function<PropertyModel, PropertyEntity> {
    @Override
    public PropertyEntity apply(PropertyModel propertyModel) {
        return PropertyEntity.builder()
                .id(!propertyModel.getId().isEmpty() ? propertyModel.getId() : null)
                .codRef(propertyModel.getCodRef())
                .address(propertyModel.getAddress())
                .alt(propertyModel.getAlt())
                .bathrooms(propertyModel.getBathrooms())
                .bedrooms(propertyModel.getBedrooms())
                .features(propertyModel.getFeatures())
                .hec(propertyModel.getHec())
                .href(propertyModel.getHref())
                .images(propertyModel.getImages())
                .location(propertyModel.getLocation())
                .price(propertyModel.getPrice())
                .priceSquareMeter(propertyModel.getPriceSquareMeter())
                .province(propertyModel.getProvince())
                .squareMeter(propertyModel.getSquareMeter())
                .title(propertyModel.getTitle())
                .build();
    }
}

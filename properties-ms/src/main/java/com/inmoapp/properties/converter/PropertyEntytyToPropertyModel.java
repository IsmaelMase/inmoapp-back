package com.inmoapp.properties.converter;

import com.inmoapp.properties.entity.PropertyEntity;
import com.inmoapp.properties.model.PropertyModel;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class PropertyEntytyToPropertyModel implements Function<PropertyEntity, PropertyModel> {
    @Override
    public PropertyModel apply(PropertyEntity propertyEntity) {
        return PropertyModel.builder()
                .id(propertyEntity.getId())
                .codRef(propertyEntity.getCodRef())
                .address(propertyEntity.getAddress())
                .alt(propertyEntity.getAlt())
                .bathrooms(propertyEntity.getBathrooms())
                .bedrooms(propertyEntity.getBedrooms())
                .features(propertyEntity.getFeatures())
                .hec(propertyEntity.getHec())
                .href(propertyEntity.getHref())
                .images(propertyEntity.getImages())
                .location(propertyEntity.getLocation())
                .price(propertyEntity.getPrice())
                .priceSquareMeter(propertyEntity.getPriceSquareMeter())
                .province(propertyEntity.getProvince())
                .squareMeter(propertyEntity.getSquareMeter())
                .title(propertyEntity.getTitle())
                .build();
    }
}

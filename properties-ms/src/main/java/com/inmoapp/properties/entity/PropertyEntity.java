package com.inmoapp.properties.entity;

import io.swagger.annotations.ApiModel;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Document(collection = "property")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(value = "Property", description = "Model of property")
public class PropertyEntity {

    @Id
    public String id;
    public String codRef;
    public String title;
    public String href;
    public List<String> images;
    public String price;
    public String province;
    public String address;
    public String location;
    public int squareMeter;
    public double alt;
    public int bathrooms;
    public double priceSquareMeter;
    public double hec;
    public int bedrooms;
    public String features;
}

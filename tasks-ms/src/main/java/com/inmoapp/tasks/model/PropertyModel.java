package com.inmoapp.tasks.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PropertyModel {

    public String id;
    @NotEmpty
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

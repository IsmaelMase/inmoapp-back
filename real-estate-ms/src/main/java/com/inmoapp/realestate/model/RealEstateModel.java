package com.inmoapp.realestate.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RealEstateModel {

    @NotNull
    public String id;
    @NotEmpty
    public String name;
    @NotEmpty
    public String emailContact;
    @NotEmpty
    public String phoneContacte;
    @NotEmpty
    public String address;
}

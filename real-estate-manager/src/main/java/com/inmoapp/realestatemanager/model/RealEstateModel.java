package com.inmoapp.realestatemanager.model;

import lombok.*;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RealEstateModel {

    public String id;
    @NotEmpty
    private String cif;
    @NotEmpty
    public String name;
    @NotEmpty
    public String emailContact;
    @NotEmpty
    public String phoneContacte;
    @NotEmpty
    public String address;
}

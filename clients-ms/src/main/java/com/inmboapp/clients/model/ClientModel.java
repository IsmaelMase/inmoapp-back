package com.inmboapp.clients.model;

import io.swagger.annotations.ApiModel;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientModel {

    public String id;
    @NotEmpty
    public String dni;
    @NotEmpty
    public String name;
    @NotEmpty
    public String subname;
    public String emailContact;
    public String phoneContact;
    public String address;
}

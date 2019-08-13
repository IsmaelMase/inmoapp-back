package com.inmboapp.clients.entity;

import io.swagger.annotations.ApiModel;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "clients")
@Getter
@Setter
@Builder
@ApiModel(value = "Clients", description = "Model of clients")
public class ClientEntity {

    @Id
    public String id;
    public String dni;
    public String name;
    public String subname;
    public String emailContact;
    public String phoneContact;
    public String address;
}

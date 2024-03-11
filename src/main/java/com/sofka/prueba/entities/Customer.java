package com.sofka.prueba.entities;

import jakarta.persistence.Entity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
public class Customer extends Person {

    private Long clientId;
    private String password;
    private boolean status;
}

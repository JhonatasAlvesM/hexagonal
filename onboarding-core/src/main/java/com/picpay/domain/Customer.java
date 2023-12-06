package com.picpay.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    private String name;
    private String id;

    private Address address;
    private String cpf;
    private Boolean isValidCpf;
    private String zipCode;

}
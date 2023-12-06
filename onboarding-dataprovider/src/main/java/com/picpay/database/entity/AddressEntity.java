package com.picpay.database.entity;

import lombok.Data;

@Data
public class AddressEntity {
    private String street;

    private String city;

    private String state;

    @Override
    public String toString() {
        return "AddressEntity{" +
                "street='" + street + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}

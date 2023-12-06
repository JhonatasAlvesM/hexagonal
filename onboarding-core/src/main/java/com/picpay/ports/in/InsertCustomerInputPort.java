package com.picpay.ports.in;

import com.picpay.domain.Customer;

public interface InsertCustomerInputPort {

    void insert(Customer customer, String zipCode);
}

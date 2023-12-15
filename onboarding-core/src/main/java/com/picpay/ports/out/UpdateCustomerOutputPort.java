package com.picpay.ports.out;

import com.picpay.domain.Customer;

public interface UpdateCustomerOutputPort {

    void update(Customer customer);
}

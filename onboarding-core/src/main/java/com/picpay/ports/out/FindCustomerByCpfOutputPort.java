package com.picpay.ports.out;

import com.picpay.domain.Customer;

import java.util.Optional;

public interface FindCustomerByCpfOutputPort {

    Optional<Customer> find(String cpf);
}

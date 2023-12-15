package com.picpay.adapter;

import com.picpay.database.repository.CustomerRepository;
import com.picpay.domain.Customer;
import com.picpay.mapper.CustomerEntityMapper;
import com.picpay.ports.out.FindCustomerByCpfOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class FindCustomerByCpfAdapter implements FindCustomerByCpfOutputPort {

    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper customerEntityMapper;


    @Override
    public Optional<Customer> find(String cpf) {
        return customerRepository.findCutomerByCpf(cpf).map(customerEntityMapper::toCustomer);

    }
}

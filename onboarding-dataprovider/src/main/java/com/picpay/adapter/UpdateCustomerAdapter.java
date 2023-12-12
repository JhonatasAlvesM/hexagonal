package com.picpay.adapter;

import com.picpay.database.repository.CustomerRepository;
import com.picpay.domain.Customer;
import com.picpay.mapper.CustomerEntityMapper;
import com.picpay.ports.out.UpdateCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateCustomerAdapter implements UpdateCustomerOutputPort {

    private final CustomerRepository customerRepository;

    private final CustomerEntityMapper customerEntityMapper;

    @Override
    public void updateCustomer(Customer customer) {
       var customerEntity = customerEntityMapper.toCustomerEntity(customer);
       customerRepository.save(customerEntity);

    }
}

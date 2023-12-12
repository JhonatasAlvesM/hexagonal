package com.picpay.usecase;

import com.picpay.ports.in.UpdateCpfInputPort;
import com.picpay.ports.out.FindCustomerByCpfOutputPort;
import com.picpay.ports.out.UpdateCustomerOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateCpfUseCase implements UpdateCpfInputPort {

    private final FindCustomerByCpfOutputPort findCustomerByCpfOutputPort;

    private final UpdateCustomerOutputPort updateCustomerOutputPort;

    @Override
    public void updateCpf(String cpf, boolean isValid) {
        var customer = findCustomerByCpfOutputPort.findCustomerByCpf(cpf).orElseThrow(()-> new RuntimeException("Deu erro Ops..."));
        customer.setIsValidCpf(isValid);

        updateCustomerOutputPort.updateCustomer(customer);






    }
}

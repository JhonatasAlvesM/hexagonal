package com.picpay.usecase;


import com.picpay.domain.Customer;
import com.picpay.exceptions.CpfAlreadyExists;
import com.picpay.ports.in.InsertCustomerInputPort;
import com.picpay.ports.out.FindAddressByZipCodeOutpuPort;
import com.picpay.ports.out.FindCustomerByCpfOutputPort;
import com.picpay.ports.out.InsertCustomerOutpuPort;
import com.picpay.ports.in.ValidationCpfInputPort;
import com.picpay.ports.out.SendCpfValidationOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindCustomerByCpfOutputPort findCustomerByCpfOutputPort;

    private final FindAddressByZipCodeOutpuPort findAddressByZipCodeOutpuPort;

    private final InsertCustomerOutpuPort insertCustomerOutpuPort;

    private  final SendCpfValidationOutputPort sendCpfForValidationOutputPort;



    @Override
    public void insert(Customer customer, String zipCode ){

        var isPresent = findCustomerByCpfOutputPort.findCustomerByCpf(customer.getCpf()).isPresent();
        if(isPresent){
            throw new CpfAlreadyExists("Cpf já está persistindo no banco de dados");

        }
        var address = findAddressByZipCodeOutpuPort.find(zipCode);
        customer.setAddress(address);
        insertCustomerOutpuPort.insert(customer);
        sendCpfForValidationOutputPort.send(customer.getCpf());

    }

}

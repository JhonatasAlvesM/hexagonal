package com.picpay.usecase;


import com.picpay.domain.Customer;
import com.picpay.ports.in.InsertCustomerInputPort;
import com.picpay.ports.out.FindAddressByZipCodeOutpuPort;
import com.picpay.ports.out.InsertCustomerOutpuPort;
import com.picpay.ports.out.SendCpfForValidationOutputPort;
import org.springframework.stereotype.Service;

@Service
public class InsertCustomerUseCase implements InsertCustomerInputPort {

    private final FindAddressByZipCodeOutpuPort findAddressByZipCodeOutpuPort;

    private final InsertCustomerOutpuPort insertCustomerOutpuPort;

    private  final SendCpfForValidationOutputPort sendCpfForValidationOutputPort;

    public InsertCustomerUseCase(
            FindAddressByZipCodeOutpuPort findAddressByZipCodeOutpuPort,
            InsertCustomerOutpuPort insertCustomerOutpuPort,
            SendCpfForValidationOutputPort sendCpfForValidationOutputPort){
        this.findAddressByZipCodeOutpuPort = findAddressByZipCodeOutpuPort;
        this.insertCustomerOutpuPort = insertCustomerOutpuPort;
        this.sendCpfForValidationOutputPort = sendCpfForValidationOutputPort;
    }

    @Override
    public void insert(Customer customer, String zipCode ){
        var address = findAddressByZipCodeOutpuPort.find(zipCode);
        customer.setIsValidCpf(sendCpfForValidationOutputPort.send(customer.getCpf()));
        customer.setAddress(address);
        insertCustomerOutpuPort.insert(customer);

    }

}

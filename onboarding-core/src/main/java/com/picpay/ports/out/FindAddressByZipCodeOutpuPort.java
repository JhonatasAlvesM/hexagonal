package com.picpay.ports.out;

import com.picpay.domain.Address;

public interface FindAddressByZipCodeOutpuPort {

    Address find(String zipcode);
}

package com.picpay.adapter;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.picpay.client.response.AddressResponse;

@FeignClient(
        name = "FindAddressByZipCodeClient",
        url = "${jhonatas.client.address.url}"
//        url = "localhost:8082/addresses"
)
public interface FindAddressByZipCodeClient {
    @GetMapping("/{zipCode}")
    AddressResponse find(@PathVariable("zipCode") String zipcode);
}

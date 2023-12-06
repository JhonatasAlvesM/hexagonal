package com.picpay.mapper;


import com.picpay.client.response.AddressResponse;
import com.picpay.domain.Address;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AddressResponseMapper {

     Address toAddress(AddressResponse addressResponse);
}

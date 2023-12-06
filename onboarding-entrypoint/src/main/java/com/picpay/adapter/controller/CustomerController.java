package com.picpay.adapter.controller;


import com.picpay.adapter.controller.mapper.CustomerMapper;
import com.picpay.adapter.controller.request.CustomerRequest;
import com.picpay.ports.in.InsertCustomerInputPort;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
//@Api(value = "Customer")
@RequestMapping("/api/v1/customers")
public class CustomerController {

    @Autowired
    private InsertCustomerInputPort insertCustomerInputPort;

    @Autowired
    private CustomerMapper customerMapper;

    //    @ApiOperation(value = "Inseri customer, validando seu cpf")
    @PostMapping(value = "/post", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> insert(@Valid @RequestBody CustomerRequest customerRequest){
        var customer = customerMapper.toCustomer(customerRequest);
        insertCustomerInputPort.insert(customer, customerRequest.getZipCode());
        return ResponseEntity.ok().body("Inserido com sucesso");
    }
}

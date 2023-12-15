package com.picpay.ports.out;

public interface SendResultCpfValidationOutputPort {

    void send(String cpf, boolean isValidCPf);
}

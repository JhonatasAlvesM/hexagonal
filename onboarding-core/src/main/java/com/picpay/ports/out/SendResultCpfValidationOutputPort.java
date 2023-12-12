package com.picpay.ports.out;

public interface SendResultCpfValidationOutputPort {

    void sendCpfResult(String cpf, boolean isValidCPf);
}

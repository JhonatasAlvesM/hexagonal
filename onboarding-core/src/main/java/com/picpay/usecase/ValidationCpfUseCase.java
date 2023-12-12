package com.picpay.usecase;


import com.picpay.ports.in.ValidationCpfInputPort;
import com.picpay.ports.out.SendResultCpfValidationOutputPort;
import com.picpay.utils.ValidateCpfUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidationCpfUseCase implements ValidationCpfInputPort {

    private final SendResultCpfValidationOutputPort sendResultCpfValidationOutputPort;



    @Override
    public void validation(String cpf) {
        boolean isValid =  ValidateCpfUtils.validaCPF(cpf);
        sendResultCpfValidationOutputPort.sendCpfResult(cpf, isValid);

    }


}

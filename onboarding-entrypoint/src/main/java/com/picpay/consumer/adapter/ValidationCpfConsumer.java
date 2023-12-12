package com.picpay.consumer.adapter;

import com.picpay.consumer.event.UpdateCpfEvent;
import com.picpay.ports.in.ValidationCpfInputPort;
import com.picpay.ports.out.SendResultCpfValidationOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@RequiredArgsConstructor
public class ValidationCpfConsumer {

    private final ValidationCpfInputPort validationCpfInputPort;

    public void receive(String cpf){
        validationCpfInputPort.validation(cpf);
    }
    @Bean
    public Consumer<String> receiveCPF(){
        return this::receive;
    }


}

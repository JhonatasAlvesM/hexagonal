package com.picpay.adapter;

import com.picpay.kafka.KafkaProducer;
import com.picpay.kafka.event.ValidationCpfEvent;
import com.picpay.ports.out.SendResultCpfValidationOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SendResultCpfValidationAdapter implements SendResultCpfValidationOutputPort {


    private final KafkaProducer<ValidationCpfEvent> kafkaProducer;

    @Override
    public void sendCpfResult(String cpf, boolean isValidCPf) {
        var event = ValidationCpfEvent.builder().isValidCpf(isValidCPf).cpf(cpf).build();
        kafkaProducer.publish(event, "sendResultCpf-out-0");


    }
}

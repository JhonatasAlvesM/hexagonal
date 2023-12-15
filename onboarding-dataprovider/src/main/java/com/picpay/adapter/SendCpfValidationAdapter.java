package com.picpay.adapter;

import com.picpay.kafka.KafkaProducer;
import com.picpay.ports.in.ValidationCpfInputPort;
import com.picpay.ports.out.SendCpfValidationOutputPort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SendCpfValidationAdapter implements SendCpfValidationOutputPort {

    @Autowired
    private KafkaProducer<String> kafkaProducer;

    @Override
    public void send(String cpf) {
        kafkaProducer.publish(cpf, "sendCPF-out-0");
    }


}

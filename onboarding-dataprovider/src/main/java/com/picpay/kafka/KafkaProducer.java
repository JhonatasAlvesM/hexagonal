package com.picpay.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaProducer<T> {
    private final StreamBridge streamBridge;

    private final ObjectMapper objectMapper;

    public void publish(T event, String binding) {
        String jsonMessage = null;
        try {
            jsonMessage = objectMapper.writeValueAsString(event);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        Message<String> message = MessageBuilder
                .withPayload(jsonMessage)
                .build();
        streamBridge.send(binding, message);
    }
}

package com.msc.chat.application;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.msc.chat.domain.KafkaConst;
import com.msc.chat.domain.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaSender {
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void send(Message message) {
        try {
            String command = objectMapper.writeValueAsString(message);
            //send kafka message
            kafkaTemplate.send(KafkaConst.KAFKA_TOPIC, command).get();
        } catch (JsonProcessingException e) {
            log.info("JsonProcessingException e", e);
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
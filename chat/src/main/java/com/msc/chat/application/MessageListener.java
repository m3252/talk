package com.msc.chat.application;

import com.msc.chat.KafkaConst;
import com.msc.chat.domain.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class MessageListener {
    private final SimpMessagingTemplate template;

    @KafkaListener(
            topics = KafkaConst.KAFKA_TOPIC,
            groupId = KafkaConst.GROUP_ID
    )
    public void listen(Message message) {
        log.info("sending listener.. {}", message);
        template.convertAndSend("/topic/group", message);
    }
}

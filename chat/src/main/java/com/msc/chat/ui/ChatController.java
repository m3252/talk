package com.msc.chat.ui;

import com.msc.chat.application.KafkaSender;
import com.msc.chat.domain.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@Slf4j
@RestController
@RequiredArgsConstructor
public class ChatController {

    private final KafkaSender kafkaSender;

    @PostMapping(value = "/api/send", consumes = "application/json", produces = "application/json")
    public void sendMessage(@RequestBody Message message) {
        message.createTimestamp(LocalDateTime.now().toString());
        kafkaSender.send(message);
    }

    @SendTo("/topic/group") // http://.../app/message로 들어온 메시지를 /topic/group 구독자에게 send
    @MessageMapping("/message") // works for WebSocket protocol communication. This defines the URL mapping.
    public Message broadcastGroupMessage(@Payload Message message) {
        log.info("broadcastGroupMessage message = " + message);
        return message;
    }

}

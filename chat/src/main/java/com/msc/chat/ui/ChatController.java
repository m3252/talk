package com.msc.chat.ui;

import com.msc.chat.application.KafkaSender;
import com.msc.chat.domain.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequiredArgsConstructor
public class ChatController {

    private final KafkaSender kafkaSender;

    @PostMapping(value = "/api/send", consumes = "application/json", produces = "application/json")
    public void sendMessage(@RequestBody Message message) {
        message.createTimestamp(LocalDateTime.now().toString());
        kafkaSender.send(message);
    }

}

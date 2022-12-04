package com.msc.chat.ui;

import com.msc.chat.application.KafkaSender;
import com.msc.chat.domain.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
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

    @MessageMapping("/chat/message") //클라이언트가 send 할 수 있는 경로, WebSocketConfig 에서 등록한 setApplicationDestinationPrefixes 경로가 합쳐진다.(/app/chat/message)
    @SendTo("/topic/group")
    public Message broadcastGroupMessage(@Payload Message message) {
        log.info("Broadcast Group Message = {}", message);
        return message;
    }

    @MessageMapping("/chat/join")
    @SendTo("/topic/group")
    public Message joinChatroom(@Payload Message message,
                           SimpMessageHeaderAccessor headerAccessor) {
        log.info("join = {}", message);
        // Add user in web socket session
        headerAccessor.getSessionAttributes().put("username", message.getSender());
        return message;
    }
}

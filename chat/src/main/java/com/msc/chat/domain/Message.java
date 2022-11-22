package com.msc.chat.domain;

import lombok.Getter;

@Getter
public class Message {

    private String sender;

    private String content;

    private String timestamp;

    public Message() {
    }

    public void createTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sender='" + sender + '\'' +
                ", content='" + content + '\'' +
                ", timestamp='" + timestamp + '\'' +
                '}';
    }
}

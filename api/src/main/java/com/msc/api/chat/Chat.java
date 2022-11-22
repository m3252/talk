package com.msc.api.chat;

import com.msc.api.global.BaseEntity;
import com.msc.api.member.Member;

public class Chat extends BaseEntity {

    private Long sequence;

    private Chatroom chatroom;

    private Member member;

    private String message;

    private String status;
}

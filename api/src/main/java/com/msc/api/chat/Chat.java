package com.msc.api.chat;

import com.msc.api.global.BaseEntity;
import com.msc.api.member.Member;

public class Chat extends BaseEntity {

    private Long sequence;

    private Long chatroomId;

    //memberId
    private Long from;

    //memberId
    private Long to;

    private String content;

    private String status;
}

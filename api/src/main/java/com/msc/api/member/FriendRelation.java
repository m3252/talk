package com.msc.api.member;

import com.msc.api.global.BaseEntity;

public class FriendRelation extends BaseEntity {
    private Long sequence;
    private Long memberId;
    private Long friendId;
    private String friendNickname;
    private String status;
}

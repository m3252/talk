package com.msc.api.member;

import com.msc.api.global.BaseEntity;

public class FriendRelation extends BaseEntity {
    private Long sequence;
    private Friends friends;
    private String friend_nickname;
    private String status;
}

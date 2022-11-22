package com.msc.api.member;

import com.msc.api.global.BaseEntity;

import java.time.LocalDate;

public class Member extends BaseEntity {

    private Long sequence;

    private String id;

    private String email;

    private String password;

    private String nickname;

    private String statusMessage;

    private String contactNumber;

}

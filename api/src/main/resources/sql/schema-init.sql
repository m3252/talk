DROP TABLE IF EXISTS member;
CREATE TABLE `member`
(
    `id`            bigint       NOT NULL AUTO_INCREMENT,
    `email`         varchar(300) NOT NULL,
    `password`      varchar(50)  NOT NULL,
    `nickname`      varchar(30)  NOT NULL,
    `statusMessage` varchar(50) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE (`email`)
);

DROP TABLE IF EXISTS friend_relation;
CREATE TABLE `friend_relation`
(
    `id`             bigint NOT NULL AUTO_INCREMENT,
    `memberId`       bigint NOT NULL,
    `friendId`       bigint NOT NULL,
    `friendNickname` varchar(30) DEFAULT NULL,
    `status`         varchar(10) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE (`memberId`, `friendId`)
);


DROP TABLE IF EXISTS chat;
CREATE TABLE `chat`
(
    `id`         bigint NOT NULL AUTO_INCREMENT,
    `chatroomId` bigint NOT NULL,
    `from`       bigint NOT NULL,
    `to`         bigint NOT NULL,
    `content`    varchar(500) DEFAULT NULL,
    `isDeleted`  varchar(1)   DEFAULT 'N',
    PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS chatroom;
CREATE TABLE `chatroom`
(
    `id`        bigint NOT NULL AUTO_INCREMENT,
    `isDeleted` varchar(1) DEFAULT 'N',
    PRIMARY KEY (`id`)
);


DROP TABLE IF EXISTS chatroom_relation;
CREATE TABLE `chatroom_relation`
(
    `id`           bigint NOT NULL AUTO_INCREMENT,
    `memberId`     bigint NOT NULL,
    `chatroomId`   bigint NOT NULL,
    `chatroomName` varchar(20) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE (`memberId`, `chatroomId`)
);
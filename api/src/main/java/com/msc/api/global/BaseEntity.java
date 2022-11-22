package com.msc.api.global;


import java.time.LocalDateTime;

public abstract class BaseEntity {
    private String createdBy;
    private String updatedBy;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public void create(String createdBy, LocalDateTime createdAt) {
        this.createdAt = createdAt;
        this.createdBy = createdBy;
    }

    public void update(String updatedBy, LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
        this.updatedBy = updatedBy;
    }
}




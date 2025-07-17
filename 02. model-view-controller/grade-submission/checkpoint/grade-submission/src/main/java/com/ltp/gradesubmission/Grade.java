package com.ltp.gradesubmission;

import lombok.Data;

import java.util.UUID;

@Data
public class Grade {
    private String name;
    private String subject;
    private String score;
    private String id;

    public Grade() {
        this.id = UUID.randomUUID().toString();
    }
}
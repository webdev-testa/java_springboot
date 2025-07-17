package com.ltp.gradesubmission;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Grade {
    @NotBlank(message = "Name can't be blank")
    private String name;
    @NotBlank(message = "Subject can't be blank")
    private String subject;
    @Score(message = "Score must be a letter grade")
    private String score;
    private String id;


    public Grade() {
        this.id = UUID.randomUUID().toString();
    }
}

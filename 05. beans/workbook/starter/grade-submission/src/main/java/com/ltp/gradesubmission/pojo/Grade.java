package com.ltp.gradesubmission.pojo;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import com.ltp.gradesubmission.validation.Score;

@Data
public class Grade {

    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotBlank(message = "Subject cannot be blank")
    private String subject;
    @Score(message = "Score must be a letter grade")
    private String score;
    private String id = UUID.randomUUID().toString();

}

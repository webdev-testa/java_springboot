package com.ltp.gradesubmission;
import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data 
@AllArgsConstructor
@NoArgsConstructor
public class Grade {
    private String name;
    private String subject;
    private String score;
}

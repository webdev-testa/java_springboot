package com.ltp.gradesubmission;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;



@Controller
public class GradeController {
    
    @GetMapping("grade")
    public String getGrades(Model model){
        Grade grade = new Grade("Sean", "PopMie", "B+");
        model.addAttribute("grade", grade);
        return "grades";
    }

}

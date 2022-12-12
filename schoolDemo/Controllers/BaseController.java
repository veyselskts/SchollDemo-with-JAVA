package com.example.MVI.schoolDemo.Controllers;
import com.example.MVI.schoolDemo.Dtos.StudentDto;
import com.example.MVI.schoolDemo.ServicesImpl.StudentServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class BaseController {
     private final StudentServiceImpl studentService;

    public BaseController(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }

    @RequestMapping("/home")
    public String home() {
        return "homepage";
    }


    @GetMapping("/createStudentPage")
    public String createStudentPage(@ModelAttribute StudentDto studentDto) {
        return "studentForm" ;   }

    @GetMapping("/getAllStudens")
    public String gelAllStudentPage(Model model) {
        model.addAttribute("students",studentService.findAll());
        return "allstudentPage" ;   }

    @GetMapping("/deleteStudentPage")
    public String deleteStudentPage(@ModelAttribute StudentDto studentDto) {
        return "studentDeletePage" ;
    }
}
package com.example.MVI.schoolDemo.Controllers;

import com.example.MVI.schoolDemo.Dtos.StudentDto;
import com.example.MVI.schoolDemo.Entities.Student;
import com.example.MVI.schoolDemo.ServicesImpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value ="/student", consumes = MediaType.ALL_VALUE)
public class StudentController {

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    public StudentController(StudentServiceImpl _studentServiceImpl){
        this.studentServiceImpl=_studentServiceImpl;
    }
    @PostMapping("/create")
    public String create(@ModelAttribute StudentDto studentDto){
        studentServiceImpl.create(studentDto);
        return "homepage";
    }
    @PostMapping("/update/{id}")
    public String update(@RequestBody StudentDto studentDto, long id){
        studentServiceImpl.update(studentDto,id);
        return "studentUpdatePage";
    }

    @RequestMapping("/delete/{id}")
    public String delete(Model model,@PathVariable long id){
        studentServiceImpl.delete(id);
        return "homepage";
    }
    @GetMapping("/allStudents")
    public List<Student> findAll() {
        return studentServiceImpl.findAll();   }

    @GetMapping("/{id}")
    public Optional<Student> findById(@PathVariable long id) {
        return studentServiceImpl.findById(id);
    }

}

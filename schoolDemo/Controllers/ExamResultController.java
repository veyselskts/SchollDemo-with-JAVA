package com.example.MVI.schoolDemo.Controllers;

import com.example.MVI.schoolDemo.Dtos.ExamResultDto;
import com.example.MVI.schoolDemo.Entities.ExamResult;
import com.example.MVI.schoolDemo.ServicesImpl.ExamResultImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value ="/Results", consumes = MediaType.ALL_VALUE)
public class ExamResultController {
    private ExamResultImpl examResultImpl;
    @Autowired
    public ExamResultController(ExamResultImpl _examResultImpl){
        this.examResultImpl=_examResultImpl;
    }

    @PostMapping("/create")
    public void create(@RequestBody ExamResultDto examResultDto){
        examResultImpl.create(examResultDto);
    }

    @PostMapping("/update/{id}")
    public void update(@RequestBody ExamResultDto examResultDto,long id){
        examResultImpl.update(examResultDto,id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        examResultImpl.delete(id);
    }

    @RequestMapping("/examResult")
    public String showScores(@RequestParam(name = "id") long studentId,Model model) {
      model.addAttribute("exams",examResultImpl.getExamResultByStudentId(studentId));
        return "studentExamInspect";
    }

    public ExamResult findById(long id) {
        return examResultImpl.findById(id);
    }

   }


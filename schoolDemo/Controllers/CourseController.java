package com.example.MVI.schoolDemo.Controllers;

import com.example.MVI.schoolDemo.Dtos.CourseDto;
import com.example.MVI.schoolDemo.Entities.Course;
import com.example.MVI.schoolDemo.ServicesImpl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value ="/Courses", consumes = MediaType.ALL_VALUE)
public class CourseController {
    private CourseServiceImpl courseServiceImpl;
    @Autowired
    public void CourseController(CourseServiceImpl _courseServiceImpl){
        this.courseServiceImpl=_courseServiceImpl;
    }
    @PostMapping("/create")
    public void create(@RequestBody CourseDto courseDto){
        courseServiceImpl.create(courseDto);
    }
    @PostMapping("/update/{id}")
    public void update(@RequestBody CourseDto courseDto,long id){
        courseServiceImpl.update(courseDto,id);
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id){
        courseServiceImpl.delete(id);
    }
    @GetMapping("/allCoursesList")
    public List<Course> findAll() {
        return courseServiceImpl.findAll();   }


}

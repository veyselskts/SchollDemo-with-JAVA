package com.example.MVI.schoolDemo.Services;

import com.example.MVI.schoolDemo.Dtos.CourseDto;
import com.example.MVI.schoolDemo.Entities.Course;


import java.util.List;

public interface ICourseService {
    void create(CourseDto courseDto);
    void update(CourseDto courseDto, long id);
    void delete(long id);
    public List<Course> findAll();
}

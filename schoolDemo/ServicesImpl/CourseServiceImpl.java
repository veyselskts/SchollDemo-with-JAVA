package com.example.MVI.schoolDemo.ServicesImpl;

import com.example.MVI.schoolDemo.Dtos.CourseDto;
import com.example.MVI.schoolDemo.Entities.Course;
import com.example.MVI.schoolDemo.Repositories.ICourseRepo;
import com.example.MVI.schoolDemo.Services.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements ICourseService {

    private ICourseRepo _courseRepo;
    @Autowired
    public CourseServiceImpl(ICourseRepo courseRepo){
        this._courseRepo=courseRepo;}

    @Override
    public void create(CourseDto courseDto) {
        Course course=new Course();
        course.setName(courseDto.getName());
        _courseRepo.save(course);
    }

    @Override
    public void update(CourseDto courseDto, long id) {
        Course course=_courseRepo.findById(id).get();
        course.setName(courseDto.getName());
        _courseRepo.save(course);
    }

    @Override
    public void delete(long id) {
        _courseRepo.deleteById(id);
    }

    @Override
    public List<Course> findAll() {
        return _courseRepo.findAll();
    }
}




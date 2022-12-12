package com.example.MVI.schoolDemo.Services;

import com.example.MVI.schoolDemo.Dtos.StudentDto;
import com.example.MVI.schoolDemo.Entities.Student;

import java.util.List;
import java.util.Optional;

public interface IStudentService {
    void create(StudentDto studentDto);
    void update(StudentDto studentDto, long id);
    void delete(long id);



}

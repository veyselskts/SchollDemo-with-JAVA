package com.example.MVI.schoolDemo.ServicesImpl;

import com.example.MVI.schoolDemo.Dtos.StudentDto;
import com.example.MVI.schoolDemo.Entities.Student;
import com.example.MVI.schoolDemo.Repositories.IStudentRepo;
import com.example.MVI.schoolDemo.Services.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    private IStudentRepo _studentRepo;
    @Autowired
    public StudentServiceImpl(IStudentRepo studentRepo){
        this._studentRepo=studentRepo;
    }

    @Override
    @Transactional
    public void create(StudentDto studentDto) {
    Student student= new Student();
    student.setFullName((studentDto.getFullName()));
    student.setNumber(studentDto.getNumber());
    student.setEmail(studentDto.getEmail());
    student.setGsmNumber(studentDto.getGsmNumber());
    _studentRepo.save(student);

    }
    @Override
    public void update(StudentDto studentDto, long id) {
        Student student=_studentRepo.findById(id).get();
        student.setFullName((studentDto.getFullName()));
        student.setNumber(studentDto.getNumber());
        student.setEmail(studentDto.getEmail());
        student.setGsmNumber(studentDto.getGsmNumber());
        _studentRepo.save(student);
    }

    @Override
    public void delete(long id) {
        _studentRepo.deleteById(id);
    }

    public List<Student> findAll() {
        List<Student> students = new ArrayList<>();
        _studentRepo.findAll().forEach(students::add);
        return students;
    }

    public Optional<Student> findById(long id) {
    return  _studentRepo.findById(id);
    }

}

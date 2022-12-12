package com.example.MVI.schoolDemo.Repositories;

import com.example.MVI.schoolDemo.Entities.ExamResult;
import com.example.MVI.schoolDemo.Entities.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
@Repository
public interface IStudentRepo extends JpaRepository<Student, Long> {
}

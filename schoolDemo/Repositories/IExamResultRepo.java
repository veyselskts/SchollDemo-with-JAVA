package com.example.MVI.schoolDemo.Repositories;

import com.example.MVI.schoolDemo.Entities.ExamResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IExamResultRepo extends JpaRepository<ExamResult, Long> {
    List<ExamResult> findAllByStudentId(long studentId);

}

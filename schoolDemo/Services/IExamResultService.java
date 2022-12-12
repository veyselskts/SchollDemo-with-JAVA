package com.example.MVI.schoolDemo.Services;

import com.example.MVI.schoolDemo.Dtos.ExamResultDto;
import com.example.MVI.schoolDemo.Entities.ExamResult;

import java.util.List;

public interface IExamResultService {
    void create(ExamResultDto examResultDto);
    void update(ExamResultDto examResultDto, long id);
    void delete(long id);
    List<ExamResultDto> getExamResultByStudentId(long id);
}

package com.example.MVI.schoolDemo.ServicesImpl;

import com.example.MVI.schoolDemo.Dtos.ExamResultDto;
import com.example.MVI.schoolDemo.Entities.Course;
import com.example.MVI.schoolDemo.Entities.ExamResult;
import com.example.MVI.schoolDemo.Repositories.ICourseRepo;
import com.example.MVI.schoolDemo.Repositories.IExamResultRepo;
import com.example.MVI.schoolDemo.Services.IExamResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ExamResultImpl implements IExamResultService {


    private IExamResultRepo _examResultRepo;
    private final ICourseRepo courseRepo;

    @Autowired
    public ExamResultImpl(IExamResultRepo examResultRepo, ICourseRepo courseRepo){
        this._examResultRepo=examResultRepo;

        this.courseRepo = courseRepo;
    }

    @Override
    public void create(ExamResultDto examResultDto) {
        ExamResult examResult=new ExamResult();
        examResult.setCourseId(examResultDto.getCourseId());
        examResult.setStudentId(examResultDto.getStudentId());
        examResult.setScore(examResultDto.getScore());
        _examResultRepo.save(examResult);
    }

    @Override
    public void update(ExamResultDto examResultDto, long id) {
    ExamResult examResult=_examResultRepo.findById(id).get();
    examResult.setCourseId(examResultDto.getCourseId());
    examResult.setStudentId(examResultDto.getStudentId());
    examResult.setScore(examResultDto.getScore());
    _examResultRepo.save(examResult);
    }

    @Override
    public void delete(long id) {
    _examResultRepo.deleteById(id);
    }

    public ExamResult findById(long id) {
        Optional<ExamResult> findResult = _examResultRepo.findById(id);
        ExamResult examResult = null;

        if (findResult.isPresent()) {
            examResult = findResult.get();
        } else {
            throw new RuntimeException("Did not find result of exam by this id: " + id);
        }
        return examResult;
    }

    public Optional<ExamResult> showScores(long studentId) {

        return _examResultRepo.findById(studentId);
    }

    public List<ExamResultDto> getExamResultByStudentId(long id){
        List<ExamResultDto> examResultDtos = new ArrayList<>();
        for (ExamResult examResult : _examResultRepo.findAllByStudentId(id) ){
           ExamResultDto examResultDto = new ExamResultDto();
           examResultDto.setStudentId(examResult.getStudentId());
           examResultDto.setScore(examResult.getScore());
            Optional<Course> course  = courseRepo.findById(examResult.getCourseId());
           examResultDto.setCourseName(course.get().getName());
            examResultDtos.add(examResultDto);

        }
        return examResultDtos;
    }

}

package com.example.MVI.schoolDemo.Entities;

import javax.persistence.*;

@Entity
@Table(name="exam_result")
public class ExamResult {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="student_id")
    private Long studentId;

    @Column(name="course_id")
    private Long courseId;

    @Column(name="score")
    private int score;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public Long getStudentId() {
        return studentId;
    }
    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }

    public Long getCourseId() {
        return courseId;
    }
    public void setCourseId(Long courseId) {
        this.courseId = courseId;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}

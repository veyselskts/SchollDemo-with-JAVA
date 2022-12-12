package com.example.MVI.schoolDemo.Repositories;

import com.example.MVI.schoolDemo.Entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICourseRepo extends JpaRepository<Course, Long> {
}

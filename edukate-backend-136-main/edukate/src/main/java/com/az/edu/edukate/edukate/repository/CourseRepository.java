package com.az.edu.edukate.edukate.repository;

import com.az.edu.edukate.edukate.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}

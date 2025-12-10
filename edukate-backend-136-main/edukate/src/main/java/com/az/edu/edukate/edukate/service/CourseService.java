package com.az.edu.edukate.edukate.service;

import com.az.edu.edukate.edukate.dto.course.CourseDetailDto;
import com.az.edu.edukate.edukate.dto.course.CourseDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> getAllCourses();

    CourseDetailDto getCourseById(Long id);
}

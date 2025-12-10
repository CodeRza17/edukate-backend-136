package com.az.edu.edukate.edukate.service.impl;

import com.az.edu.edukate.edukate.dto.course.CourseDetailDto;
import com.az.edu.edukate.edukate.dto.course.CourseDto;
import com.az.edu.edukate.edukate.model.Category;
import com.az.edu.edukate.edukate.model.Course;
import com.az.edu.edukate.edukate.repository.CourseRepository;
import com.az.edu.edukate.edukate.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CourseDto> getAllCourses() {
        List<Course> courses = courseRepository.findAll();
        return courses
                .stream()
                .map(c -> modelMapper.map(c, CourseDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public CourseDetailDto getCourseById(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(()->new RuntimeException("Course Not Found"));
        CourseDetailDto courseDetailDto = modelMapper.map(course, CourseDetailDto.class);
        courseDetailDto.setLevelName(course.getLevel().getName());
        courseDetailDto.setLanguageName(course.getLanguage().getName());
        List<String> coursesNames = new ArrayList<>();
        for (Category category : course.getCategories()){
            coursesNames.add(category.getName());
        }
        courseDetailDto.setCategoriesNames(coursesNames);
        return courseDetailDto;
    }
}

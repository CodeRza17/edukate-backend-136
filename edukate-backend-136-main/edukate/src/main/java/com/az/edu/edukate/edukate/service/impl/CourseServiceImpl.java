package com.az.edu.edukate.edukate.service.impl;

import com.az.edu.edukate.edukate.dto.category.CourseDetailCategoryDto;
import com.az.edu.edukate.edukate.dto.course.CourseDetailDto;
import com.az.edu.edukate.edukate.dto.course.CourseDto;
import com.az.edu.edukate.edukate.model.Category;
import com.az.edu.edukate.edukate.model.Course;
import com.az.edu.edukate.edukate.repository.CourseRepository;
import com.az.edu.edukate.edukate.service.CategoryService;
import com.az.edu.edukate.edukate.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CourseServiceImpl implements CourseService {
    private final CourseRepository courseRepository;
    private final ModelMapper modelMapper;
    private final CategoryService categoryService;

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
        List<CourseDetailCategoryDto> categoryDtoList = categoryService.mapToDetailDto(course.getCategories());
        courseDetailDto.setCategoriesNames(categoryDtoList);
        return courseDetailDto;
    }

    @Override
    public List<CourseDto> getRelatedCourses(Long id) {
        Course course = courseRepository.findById(id).orElseThrow(()->new RuntimeException("Course Not Found"));
        HashSet<Course> courseHashSet = new HashSet<>();
        for (Category category : course.getCategories()) {
            List<Course> courses = category.getCourses();
            for (Course course1 : courses) {
                if (!courseHashSet.contains(course1)) {
                    courseHashSet.add(course1);
                }
            }
        }
        List<CourseDto> courseDtoList = new ArrayList<>();
        for (Course course1 : courseHashSet) {
            CourseDto courseDto = modelMapper.map(course1, CourseDto.class);
            courseDtoList.add(courseDto);
        }
        return courseDtoList;
    }
}

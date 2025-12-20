package com.az.edu.edukate.edukate.service.impl;

import com.az.edu.edukate.edukate.dto.category.CourseDetailCategoryDto;
import com.az.edu.edukate.edukate.model.Category;
import com.az.edu.edukate.edukate.repository.CategoryRepository;
import com.az.edu.edukate.edukate.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<CourseDetailCategoryDto> mapToDetailDto(List<Category> categories) {
        List<CourseDetailCategoryDto> dtos = new ArrayList<>();
        for (Category category : categories) {
            CourseDetailCategoryDto dto = modelMapper.map(category, CourseDetailCategoryDto.class);
            dto.setCountOfCourses(category.getCourses().size());
            dtos.add(dto);
        }
        return dtos;
    }
}

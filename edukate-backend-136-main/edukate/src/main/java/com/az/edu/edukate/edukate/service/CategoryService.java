package com.az.edu.edukate.edukate.service;

import com.az.edu.edukate.edukate.dto.category.CourseDetailCategoryDto;
import com.az.edu.edukate.edukate.model.Category;

import java.util.List;

public interface CategoryService {
    List<CourseDetailCategoryDto> mapToDetailDto(List<Category> categories);
}

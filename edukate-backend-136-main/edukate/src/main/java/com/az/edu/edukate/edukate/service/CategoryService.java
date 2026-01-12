package com.az.edu.edukate.edukate.service;

import com.az.edu.edukate.edukate.dto.category.CategoryCreateDto;
import com.az.edu.edukate.edukate.dto.category.CategoryDashboardDto;
import com.az.edu.edukate.edukate.dto.category.CategoryUpdateDto;
import com.az.edu.edukate.edukate.dto.category.CourseDetailCategoryDto;
import com.az.edu.edukate.edukate.model.Category;

import java.util.List;

public interface CategoryService {
    List<CourseDetailCategoryDto> mapToDetailDto(List<Category> categories);

    boolean createCategory(CategoryCreateDto createDto);

    List<CategoryDashboardDto> getAllCategory();

    CategoryDashboardDto getCategoryById(Long id);

    boolean deleteCategoryById(Long id);

    boolean updateCategory(Long id, CategoryUpdateDto updateDto);
}

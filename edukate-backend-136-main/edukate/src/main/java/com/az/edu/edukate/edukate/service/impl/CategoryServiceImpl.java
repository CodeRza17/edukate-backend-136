package com.az.edu.edukate.edukate.service.impl;

import com.az.edu.edukate.edukate.dto.category.CategoryCreateDto;
import com.az.edu.edukate.edukate.dto.category.CategoryDashboardDto;
import com.az.edu.edukate.edukate.dto.category.CategoryUpdateDto;
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

    @Override
    public boolean createCategory(CategoryCreateDto createDto) {
        try{
            Category category = modelMapper.map(createDto, Category.class);
            categoryRepository.save(category);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public List<CategoryDashboardDto> getAllCategory() {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDashboardDto> dtos = new ArrayList<>();
        for (Category category : categories) {
            CategoryDashboardDto dto = modelMapper.map(category, CategoryDashboardDto.class);
            dtos.add(dto);
        }
        return dtos;
    }

    @Override
    public CategoryDashboardDto getCategoryById(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(()-> new RuntimeException("Category not found"));
        CategoryDashboardDto dto = modelMapper.map(category, CategoryDashboardDto.class);
        return dto;
    }

    @Override
    public boolean deleteCategoryById(Long id) {
        try {
            Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
            categoryRepository.delete(category);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean updateCategory(Long id, CategoryUpdateDto updateDto) {
        try{
            Category category = categoryRepository.findById(id).orElseThrow(() -> new RuntimeException("Category not found"));
            category.setName(updateDto.getName());
            categoryRepository.save(category);
            return true;
        }catch (Exception e){
            return false;
        }

    }
}

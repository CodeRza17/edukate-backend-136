package com.az.edu.edukate.edukate.controller.admin;

import com.az.edu.edukate.edukate.dto.category.CategoryCreateDto;
import com.az.edu.edukate.edukate.dto.category.CategoryDashboardDto;
import com.az.edu.edukate.edukate.dto.category.CategoryUpdateDto;
import com.az.edu.edukate.edukate.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("dashboard/category")
public class CategoryController {
    private final CategoryService categoryService;

    @GetMapping
    public String category(Model model) {
        List<CategoryDashboardDto> categoryDashboardDtoList = categoryService.getAllCategory();
        model.addAttribute("categoryDashboardDtoList", categoryDashboardDtoList);
        return "admin/category/category";
    }

    @GetMapping("/create")
    public String createCategory() {
        return "admin/category/create-category";
    }

    @PostMapping("/create")
    public String createCategory(CategoryCreateDto createDto) {
        boolean result = categoryService.createCategory(createDto);
        if (result) {
            return "redirect:/dashboard/category";
        }else {
            return "redirect:/dashboard/category/create";
        }
    }
    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id, Model model) {
        CategoryDashboardDto deleteDto = categoryService.getCategoryById(id);
        model.addAttribute("categoryDashboardDto", deleteDto);
        return "adimin/category/delete-category";
    }
    @PostMapping("/delete/{id}")
    public String deleteCategory(@PathVariable Long id) {
        boolean result = categoryService.deleteCategoryById(id);
        if (result) {
            return "redirect:/dashboard/category";
        }else{
            return "redirect:/dashboard";
        }
    }
    @GetMapping("/update/{id}")
    public String updateCategory(@PathVariable Long id, Model model) {
        CategoryDashboardDto updateDto = categoryService.getCategoryById(id);
        model.addAttribute("categoryDashboardDto", updateDto);
        return "admin/category/update-category";
    }
    @PostMapping("/update/{id}")
    public String updateCategory(@PathVariable Long id, CategoryUpdateDto updateDto) {
        boolean result = categoryService.updateCategory(id, updateDto);
        if (result) {
            return "redirect:/dashboard/category";
        }else {
            return "redirect:/dashboard";
        }
    }
}

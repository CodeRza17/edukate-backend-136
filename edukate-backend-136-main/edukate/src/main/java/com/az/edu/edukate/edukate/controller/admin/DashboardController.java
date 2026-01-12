package com.az.edu.edukate.edukate.controller.admin;

import com.az.edu.edukate.edukate.dto.category.CategoryCreateDto;
import com.az.edu.edukate.edukate.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class DashboardController {
    @GetMapping("/dashboard")
    public String dashboard() {
        return "admin/index";
    }
}

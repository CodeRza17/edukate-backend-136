package com.az.edu.edukate.edukate.controller;

import com.az.edu.edukate.edukate.dto.about.AboutParagraphDto;
import com.az.edu.edukate.edukate.dto.banner.BannerDto;
import com.az.edu.edukate.edukate.service.AboutParagraphService;
import com.az.edu.edukate.edukate.service.BannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final BannerService bannerService;
    private final AboutParagraphService aboutParagraphService;

    @GetMapping("/")
    public String home(Model model) {
//        BannerDto bannerDto = bannerService.getBannerByPageId(1L);
//        model.addAttribute("banner", bannerDto);
        model.addAttribute("activeMenu", "home");
        return "index";
    }

    @GetMapping("/about")
    public String about(Model model) {
//        BannerDto bannerDto = bannerService.getBannerByPageId(2L);
//        model.addAttribute("banner", bannerDto);
        List<AboutParagraphDto> aboutParagraphDtoList = aboutParagraphService.getAllActiveParagraph();
        model.addAttribute("aboutParagraphDtoList", aboutParagraphDtoList);
        model.addAttribute("activeMenu", "about");
        return "about";
    }

    @GetMapping("/courses")
    public String courses(Model model) {
//        BannerDto bannerDto = bannerService.getBannerByPageId(3L);
//        model.addAttribute("banner", bannerDto);
        model.addAttribute("activeMenu", "courses");
        return "course";
    }

    @GetMapping("/contact")
    public String contact(Model model) {
//        BannerDto bannerDto = bannerService.getBannerByPageId(4L);
//        model.addAttribute("banner", bannerDto);
        model.addAttribute("activeMenu", "contact");
        return "contact";
    }

    @GetMapping("/feature")
    public String features(Model model) {
//        BannerDto bannerDto = bannerService.getBannerByPageId(5L);
//        model.addAttribute("banner", bannerDto);
        model.addAttribute("activeMenu", "pages");
        return "feature";
    }

    @GetMapping("/team")
    public String team(Model model) {
//        BannerDto bannerDto = bannerService.getBannerByPageId(6L);
//        model.addAttribute("banner", bannerDto);
        model.addAttribute("activeMenu", "pages");
        return "team";
    }

    @GetMapping("/testimonial")
    public String testimonial(Model model) {
//        BannerDto bannerDto = bannerService.getBannerByPageId(7L);
//        model.addAttribute("banner", bannerDto);
        model.addAttribute("activeMenu", "pages");
        return "testimonial";
    }
}
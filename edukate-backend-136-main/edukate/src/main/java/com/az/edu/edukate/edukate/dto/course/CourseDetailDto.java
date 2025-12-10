package com.az.edu.edukate.edukate.dto.course;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDetailDto {
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private String instructor;
    private Double rating;
    private Integer countOfLectures;
    private Integer durationTime;
    private String durationType;
    private String levelName;
    private String languageName;
    private Double coursePrice;
    private List<String> categoriesNames;
}

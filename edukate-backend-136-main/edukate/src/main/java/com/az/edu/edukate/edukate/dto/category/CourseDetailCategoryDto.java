package com.az.edu.edukate.edukate.dto.category;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDetailCategoryDto {
    private Long id;
    private String name;
    private Integer countOfCourses;
}

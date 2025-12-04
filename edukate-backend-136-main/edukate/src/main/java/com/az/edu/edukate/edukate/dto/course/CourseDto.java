package com.az.edu.edukate.edukate.dto.course;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CourseDto {
    private Long id;
    private String name;
    private String imageUrl;
    private String instructor;
    private Double rating;
}

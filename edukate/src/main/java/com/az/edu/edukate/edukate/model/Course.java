package com.az.edu.edukate.edukate.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private String imageUrl;
    private String instructor;
    private Double rating;
    private Integer countOfLectures;
    private Integer durationTime;
    private String durationType;
    @ManyToOne
    private Level level;
    @ManyToOne
    private Language language;

    private Double coursePrice;

    @ManyToMany
    private List<Category> category;

    private LocalDateTime startDateTime;

}

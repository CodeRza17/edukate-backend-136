package com.az.edu.edukate.edukate.repository;


import com.az.edu.edukate.edukate.model.AboutParagraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AboutParagraphRepository extends JpaRepository<AboutParagraph, Long> {

    List<AboutParagraph> findAllByActive(boolean active);
}

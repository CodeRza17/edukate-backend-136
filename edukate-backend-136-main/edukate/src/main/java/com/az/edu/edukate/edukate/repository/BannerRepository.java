package com.az.edu.edukate.edukate.repository;


import com.az.edu.edukate.edukate.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BannerRepository  extends JpaRepository<Banner, Long> {
    Banner findByPageIdAndActive(Long pageId, boolean active);
}

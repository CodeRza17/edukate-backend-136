package com.az.edu.edukate.edukate.service;

import com.az.edu.edukate.edukate.dto.banner.BannerDto;

public interface BannerService {
    BannerDto getBannerByPageId(Long pageId);
}

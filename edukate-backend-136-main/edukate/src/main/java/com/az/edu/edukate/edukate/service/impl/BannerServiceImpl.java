package com.az.edu.edukate.edukate.service.impl;

import com.az.edu.edukate.edukate.dto.banner.BannerDto;
import com.az.edu.edukate.edukate.model.Banner;
import com.az.edu.edukate.edukate.repository.BannerRepository;
import com.az.edu.edukate.edukate.service.BannerService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService {
    private final BannerRepository bannerRepository;
    private final ModelMapper modelMapper;

    @Override
    public BannerDto getBannerByPageId(Long pageId) {
        Banner banner = bannerRepository.findByPageIdAndActive(pageId, true);
        if (banner == null) {
            throw new RuntimeException("<UNK>");
        }

        return modelMapper.map(banner, BannerDto.class);
    }
}

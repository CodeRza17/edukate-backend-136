package com.az.edu.edukate.edukate.dto.banner;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BannerDto {
    private String title;
    private String subTitle;
    private String photoUrl;
}

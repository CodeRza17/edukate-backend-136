package com.az.edu.edukate.edukate.dto.about;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AboutParagraphDto {
    private String title;
    private String content;
    private String description;
    private String photoUrl;

}

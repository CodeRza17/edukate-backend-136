package com.az.edu.edukate.edukate.service.impl;

import com.az.edu.edukate.edukate.dto.about.AboutParagraphDto;
import com.az.edu.edukate.edukate.repository.AboutParagraphRepository;
import com.az.edu.edukate.edukate.service.AboutParagraphService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AboutParagraphServiceImpl implements AboutParagraphService {
    private final AboutParagraphRepository aboutParagraphRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<AboutParagraphDto> getAllActiveParagraph() {
        return aboutParagraphRepository
                .findAllByActive(true)
                .stream()
                .map(aboutParagraph -> modelMapper.map(aboutParagraph, AboutParagraphDto.class))
                .collect(Collectors.toList());
    }
}

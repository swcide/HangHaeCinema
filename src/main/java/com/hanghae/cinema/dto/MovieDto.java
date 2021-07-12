package com.hanghae.cinema.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Getter
public class MovieDto {

    private String title;
    private String star;
    private String movie_Code;
    private String img;
}

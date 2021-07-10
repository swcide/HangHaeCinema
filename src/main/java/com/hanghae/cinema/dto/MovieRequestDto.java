package com.hanghae.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class MovieRequestDto {

    private String title;
    private String genre;
    private String actor;
    private String runtime;
    private String rating;
    private String director;
    private String year;
    private String img;
    private String plot;

}

package com.hanghae.cinema.dto.request;

import lombok.*;

import javax.persistence.Column;


@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CrawlingDto {

    private String title;
    private String star;
    private String movie_Code;
    private String img;
    private String plot;
    private String genre;
    private String year;
    private String runtime;
    private String actor;


    public CrawlingDto(String title, String star, String[] code, String img, String plot, String genre, String year, String runtime, String actor) {
        this.title = title;
        this.star = star;
        this.movie_Code = code[1];
        this.img = img;
        this.plot = plot;
        this.genre = genre;
        this.year = year;
        this.runtime = runtime;
        this.actor = actor;


    }


}

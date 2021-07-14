package com.hanghae.cinema.dto;

import lombok.*;


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



    public CrawlingDto(String title, String star, String[] code, String img, String plot) {
        this.title = title;
        this.star = star;
        this.movie_Code = code[1];
        this.img=img;
        this.plot = plot;

    }

    public CrawlingDto(String img) {
        this.img =img;
    }
}

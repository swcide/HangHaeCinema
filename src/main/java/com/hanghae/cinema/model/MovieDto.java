package com.hanghae.cinema.model;

import lombok.*;


@ToString
@NoArgsConstructor // 기본 생성자를 자동으로 만듭니다.
@Getter
@AllArgsConstructor
public class MovieDto {


    private String title;
    private String star;
    private String img;
//    private String movie_code;

    public MovieDto(CrawlingDto crawlingDto) {
        this.title = crawlingDto.getTitle();
//        this.star = crawlingDto.getStar();
//        this.img = crawlingDto.getImg();
//        this.movie_code = crawlingDto.getMovie_code();
    }



}

package com.hanghae.cinema.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReviewDto {

    private String moviecode;

    private String contents;

    private int likecount;
}

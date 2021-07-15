package com.hanghae.cinema.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReviewRequestDto {

    private String username;

    private String moviecode;

    private String contents;

    private int likecount;
}

package com.hanghae.cinema.dto;

import com.hanghae.cinema.model.Review;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LikeDto {

    private Review review;
    private String user;


}

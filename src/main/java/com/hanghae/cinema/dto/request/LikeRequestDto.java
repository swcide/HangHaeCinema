package com.hanghae.cinema.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class LikeRequestDto {
    private Long reviewId;
    private String userName;
}

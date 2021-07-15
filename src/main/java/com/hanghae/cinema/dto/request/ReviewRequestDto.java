package com.hanghae.cinema.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ReviewRequestDto {

    private Long mid;
    private String username;
    private String contents;
    private String password;
}

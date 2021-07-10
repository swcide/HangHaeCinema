package com.hanghae.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

import javax.persistence.Column;

@NoArgsConstructor // 기본 생성자를 자동으로 만듭니다.
@Getter
public class MovieDto {

    @Column(nullable = false)
    private String title;


//    public MovieDto(JSONObject itemJson) {
//        this.title = itemJson.getString("title");
//
//    }

}

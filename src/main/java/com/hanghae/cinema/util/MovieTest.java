package com.hanghae.cinema.util;


import com.hanghae.cinema.dto.MovieDto;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


//@Slf4j
//@Component
//@RequiredArgsConstructor
public class MovieTest {

//    final CrawlingRequestDto crawlingRequestDto;

    public List<MovieDto> movieListcrawling() throws Exception{
        String url = "https://movie.naver.com/movie/running/current.nhn";
        System.out.println("---------현재상영영화----------");
        System.out.println("log : " + url);
        Document doc = Jsoup.connect(url).get();
        Elements element = doc.select("dl.lst_dsc");
        return toList(element);
    }
    public List<MovieDto> toList(Elements element) {
        List<MovieDto> movieList = new ArrayList<>();
        String response_code ="";
        String[] code_split ;
        String code = "";
        String title = "";
        String img = "";
        String star ="";

        for(Element el : element){
            response_code = el.select(".tit> a").attr("href");
            code_split = response_code.split("code=");
            code = code_split[1];
            title = el.select(".tit> a").text();
            img = "https://movie.naver.com/movie/bi/mi/photoViewPopup.nhn?movieCode=" + code;
            star =el.select(".star_t1>.num").text();
            MovieDto movieDto = new MovieDto();
//            movieDto.setMovie_code(code);
//            movieDto.setTitle(title);
//            movieDto.setImg(img);
//            movieDto.setStar(star);
            movieList.add(movieDto);
        }
//
        return movieList;
    }

}

package com.hanghae.cinema.util;


import com.hanghae.cinema.model.CrawlingDto;

import com.hanghae.cinema.model.MovieDto;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component

public class MovieCrawling {

    public List<CrawlingDto> movieListcrawling() throws Exception{
        String url = "https://movie.naver.com/movie/running/current.nhn";
        Document doc = Jsoup.connect(url).get();
        Elements element = doc.select("dl.lst_dsc");
        List<MovieDto> movieDtoList =  new ArrayList<>();
        return toList(element);
    }

    public List<CrawlingDto> toList(Elements element) {
        return element
                .stream()
                .map(el->new CrawlingDto(
                        el.select(".tit>a").text(),
                        el.select(".star_t1>.num").text(),
                        el.select(".tit>a").attr("href").split("code="),
                        "https://movie.naver.com/movie/bi/mi/photoViewPopup.nhn?movieCode="
                )).collect(Collectors.toList());
    }
}

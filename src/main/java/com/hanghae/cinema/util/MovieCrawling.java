package com.hanghae.cinema.util;


import com.hanghae.cinema.dto.CrawlingDto;

import com.hanghae.cinema.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class MovieCrawling {
    private final MovieService movieService;

    // 서버 실행과 동시에 크롤링 하겠다.
    @PostConstruct
    public List<CrawlingDto> movieListcrawling() throws Exception{
        String url = "https://movie.naver.com/movie/running/current.nhn";
        Document doc = Jsoup.connect(url).get();
        Elements element = doc.select("dl.lst_dsc");

        return movieService.saveMovies(toList(element));
    }
    public List<CrawlingDto> toList(Elements element) {
        return element
                .stream()
                .map(el->new CrawlingDto(
                        el.select(".tit>a").text(),
                        el.select(" dd.star > dl.info_star > dd > div > a > span.num").text(),
                        el.select(".tit>a").attr("href").split("code="),
                        "https://movie.naver.com/movie/bi/mi/photoViewPopup.nhn?movieCode="
                )).collect(Collectors.toList());

    }
}

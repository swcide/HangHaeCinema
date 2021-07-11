package com.hanghae.cinema.controller;

import com.hanghae.cinema.model.CrawlingDto;
import com.hanghae.cinema.util.MovieCrawling;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MovieController {

    private final MovieCrawling movieCrawling;

    @GetMapping("/api/crawling")
    public List<CrawlingDto> getMoives() throws Exception {
        MovieCrawling movieTest = new MovieCrawling();


        return movieTest.movieListcrawling();

    }

}

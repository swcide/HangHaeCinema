package com.hanghae.cinema.controller;

import com.hanghae.cinema.dto.MovieRequestDto;
import com.hanghae.cinema.model.Movie;
import com.hanghae.cinema.model.MovieDto;
import com.hanghae.cinema.repository.MovieRepository;
import com.hanghae.cinema.util.MovieCrawling;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
public class MovieController {


    private final MovieCrawling movieCrawling;

    @GetMapping("/api/crawling")
    public List<MovieDto> getMoives() throws Exception {

        String resultString = movieCrawling.crawling();


        return resultString;
//        for ()
//        return movieCrawling.fromJSONtoMovies(resultString);
    }

}

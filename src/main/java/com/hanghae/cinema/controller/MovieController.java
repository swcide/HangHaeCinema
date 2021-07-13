package com.hanghae.cinema.controller;

import com.hanghae.cinema.dto.CrawlingDto;
import com.hanghae.cinema.model.Movie;
import com.hanghae.cinema.repository.MovieRepository;
import com.hanghae.cinema.service.MovieService;
import com.hanghae.cinema.util.MovieCrawling;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MovieController {

    private final MovieCrawling movieCrawling;
    private final MovieRepository movieRepository;
    private final MovieService movieService;

    // 영화 목록 페이징
    @GetMapping("/api/movie")
    public Page<Movie> getMoives()  {
        int page = 1;
        int size = 10;
        page= page-1;
        return movieService.getMovie(page,size);
    }



}

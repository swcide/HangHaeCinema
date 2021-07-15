package com.hanghae.cinema.controller;


import com.hanghae.cinema.model.Movie;
import com.hanghae.cinema.service.MovieService;
import com.hanghae.cinema.util.MovieCrawling;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
public class MovieController {

    private final MovieService movieService;
    private final MovieCrawling movieCrawling;

    @GetMapping("/api/test")
    public String test() throws Exception {
        movieCrawling.movieListcrawling();
        return "";
    }

    // 영화 목록 페이징
    @GetMapping("/api/movie")
    public Page<Movie> getMoives(@RequestParam("size") int size,
                                 @RequestParam("page") int page){
        return movieService.getMovie(page,size);
    }

    @GetMapping("/api/movie/detail/{id}")
    public Movie getMoiveDetail(@PathVariable Long id)  {
        return movieService.getMovieDetail(id);
    }
}

package com.hanghae.cinema.service;

import com.hanghae.cinema.dto.request.CrawlingDto;
import com.hanghae.cinema.exception.ApiRequestException;
import com.hanghae.cinema.model.Movie;
import com.hanghae.cinema.repository.MovieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class MovieService {
    final MovieRepository movieRepository;
    // 크롤링 저장.
    public List<CrawlingDto> saveMovies(List<CrawlingDto> crawlingList) {


        List<Movie> movies = crawlingList.
                stream().
                map(crawling -> new Movie(
                    crawling.getTitle(),
                    crawling.getStar(),
                    crawling.getMovie_Code(),
                    crawling.getImg(),
                    crawling.getPlot(),
                    crawling.getGenre(),
                    crawling.getYear(),
                    crawling.getRuntime(),
                    crawling.getActor()
                )).collect(Collectors.toList());
        movieRepository.saveAll(movies);
        return crawlingList;
    }
    // 영화 목록 페이징.

    public Page<Movie> getMovie(int page,int size) {
        Pageable pageable = PageRequest.of(page ,size);
        return movieRepository.findAll(pageable);
    }

    public Movie getMovieDetail(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ApiRequestException("영화정보가 존재하지 않습니다."));



        return movie;
    }
}

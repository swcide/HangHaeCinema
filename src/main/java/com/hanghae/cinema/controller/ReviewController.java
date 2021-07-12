package com.hanghae.cinema.controller;

import com.hanghae.cinema.dto.ReviewDto;
import com.hanghae.cinema.model.Review;
import com.hanghae.cinema.repository.ReviewRepository;
import com.hanghae.cinema.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


@RestController
@RequiredArgsConstructor
public class ReviewController {

    final ReviewRepository reviewRepository;
    final ReviewService reviewService;

    @PostMapping("/api/review")
    public Review reviewWrite(@RequestBody ReviewDto reviewDto) {

        System.out.println("zzzz 들어옴?");
        Review review = new Review(reviewDto);
        reviewRepository.save(review);

        return review;
    }

    @GetMapping("/api/review/{moviecode}")
    public Page<Review> getReview(@PathVariable String moviecode,
                                   @RequestParam("page") int page,
                                   @RequestParam("size") int size){

        page = 1;
        size = 10;


        page= page-1;
        return reviewService.getReview(moviecode,page,size);

    }



}
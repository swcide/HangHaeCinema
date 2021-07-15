package com.hanghae.cinema.controller;

import com.hanghae.cinema.dto.request.ReviewRequestDto;
import com.hanghae.cinema.model.Review;
import com.hanghae.cinema.repository.ReviewRepository;
import com.hanghae.cinema.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class ReviewController {

    final ReviewRepository reviewRepository;
    final ReviewService reviewService;
    @PostMapping("/api/review")
    public Review writeReview(@RequestBody ReviewRequestDto reviewDto) {
        Review review = new Review(reviewDto);
        reviewRepository.save(review);
        return review;
    }
    //리뷰 목록 페이징
    @GetMapping("/api/review/{id}")
    public List<Review> getReview(@PathVariable Long id ){

        return reviewService.getReview(id);
    }
    //리뷰 업데이트
    @PutMapping("/api/review/update/{id}")
    public Long updateReview(@PathVariable Long id, @RequestBody ReviewRequestDto reviewDto) {

        return reviewService.updateReview(reviewDto, id);
    }
    // 리뷰 삭제
    @DeleteMapping("/api/review/delete/{id}")
    public Long deleteReview(@PathVariable Long id, @RequestParam("password")String password) {

        return reviewService.deleteReview(id,password);
    // 리뷰 등록
    }
}
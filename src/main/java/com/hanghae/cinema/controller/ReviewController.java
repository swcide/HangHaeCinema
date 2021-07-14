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
    // 리뷰 등록
    @PostMapping("/api/review")
    public Review writeReview(@RequestBody ReviewDto reviewDto) {
        Review review = new Review(reviewDto);
        reviewRepository.save(review);
        return review;
    }
    //리뷰 목록 페이징
    @GetMapping("/api/review/{moviecode}")
    public Page<Review> getReview(@PathVariable String moviecode
                                   ){
        int page = 1;
        int size = 10;
        page= page-1;
        System.out.println(page+"??????????");
        return reviewService.getReview(moviecode,page,size);
    }
    //리뷰 업데이트
    @PutMapping("/api/review/update/{id}")
    public Long updateReview(@PathVariable Long id, @RequestBody ReviewDto reviewDto) {

        return reviewService.updateReview(reviewDto, id);
    }
    // 리뷰 삭제
    @DeleteMapping("/api/review/delete/{id}")
    public Long deleteReview(@PathVariable Long id) {

        return reviewService.deleteReview(id);
    }
}
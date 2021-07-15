package com.hanghae.cinema.service;

import com.hanghae.cinema.dto.request.ReviewRequestDto;
import com.hanghae.cinema.exception.ApiRequestException;
import com.hanghae.cinema.model.Review;
import com.hanghae.cinema.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    // 리뷰 목록 페이징
    public List<Review> getReview(Long id) {

        if(reviewRepository.findReviewByIdOrderByCreatedAtDesc(id).size() == 0){
            throw new ApiRequestException("등록된 리뷰가 없습니다.");
        }

        return reviewRepository.findReviewByIdOrderByCreatedAtDesc(id);
    }

    //업데이트
    @Transactional
    public Long updateReview(ReviewRequestDto reviewDto, Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new ApiRequestException("해당 아이디가 존재하지 않습니다.")
        );
        review.updateReview(reviewDto);
        return review.getId();
    }

    // 삭제
    public Long deleteReview( Long id) {
        reviewRepository.deleteById(id);
        return id;
    }
}

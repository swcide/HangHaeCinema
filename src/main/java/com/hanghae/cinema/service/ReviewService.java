package com.hanghae.cinema.service;

import com.hanghae.cinema.dto.ReviewDto;
import com.hanghae.cinema.exception.ApiRequestException;
import com.hanghae.cinema.model.Review;
import com.hanghae.cinema.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    // 리뷰 목록 페이징
    public Page<Review> getReview(String moviecode, int page, int size) {
        System.out.println(page+"서비스");
        
        Pageable pageable = PageRequest.of(page, size);

        if(reviewRepository.findReviewByMoviecodeOrderByCreatedAtDesc(moviecode,pageable).getContent().size() == 0){
            throw new ApiRequestException("등록된 리뷰가 없습니다.");
        }

        return reviewRepository.findReviewByMoviecodeOrderByCreatedAtDesc(moviecode,pageable);
    }

    //업데이트
    @Transactional
    public Long updateReview(ReviewDto reviewDto, Long id) {
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

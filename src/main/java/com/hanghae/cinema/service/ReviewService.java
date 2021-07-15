package com.hanghae.cinema.service;

import com.hanghae.cinema.dto.request.ReviewRequestDto;
import com.hanghae.cinema.exception.ApiRequestException;
import com.hanghae.cinema.model.Review;
import com.hanghae.cinema.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    // 리뷰 목록 페이징
    public List<Review> getReview(Long id) {
        if(reviewRepository.findByMidOrderByCreatedAtDesc(id).size() == 0){

            throw new ApiRequestException("등록된 리뷰가 없습니다.");
        }
        return reviewRepository.findByMidOrderByCreatedAtDesc(id);
    }

    //업데이트
    @Transactional
    public Long updateReview(ReviewRequestDto reviewDto, Long id) {
        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new ApiRequestException("해당 아이디가 존재하지 않습니다."));

        if (!review.getPassword().equals(reviewDto.getPassword())){
            throw new ApiRequestException("비밀번호가 다릅니다 선생님..");
        }

        review.updateReview(reviewDto);
        return review.getId();
    }
    // 삭제
    public ResponseEntity<Void> deleteReview(Long id, ReviewRequestDto reviewDto) {
        Review review = reviewRepository.findById(id).orElseThrow(
                () -> new ApiRequestException("해당 아이디가 존재하지 않습니다."));
        if(!reviewDto.getPassword().equals(review.getPassword())){
            throw new ApiRequestException("비밀번호가 다릅니다 선생님..");
        }
        reviewRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

package com.hanghae.cinema.service;

import com.hanghae.cinema.dto.request.LikeRequestDto;
import com.hanghae.cinema.model.LikeReview;
import com.hanghae.cinema.model.Review;
import com.hanghae.cinema.repository.LikeRepository;
import com.hanghae.cinema.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LikeService {
    final LikeRepository likeRepository;
    final ReviewRepository reviewRepository;

    public void clickLike(LikeRequestDto likeResponseDto) {

        Review review = reviewRepository.findReviewById(likeResponseDto.getReviewId());
        LikeReview likeReviewew =new LikeReview(review,likeResponseDto.getUserName());

        likeRepository.save(likeReviewew);
    }

    public void deleteLike(LikeRequestDto likeResponseDto) {
        LikeReview likeReview =likeRepository
                .findLikeReviewByReviewIdAndUser(likeResponseDto.getReviewId(),
                        likeResponseDto.getUserName());
        likeRepository.delete(likeReview);
    }


}

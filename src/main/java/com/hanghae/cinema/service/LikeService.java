package com.hanghae.cinema.service;

import com.hanghae.cinema.dto.LikeDto;
import com.hanghae.cinema.dto.LikeResponseDto;
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

    public void clickLike(LikeResponseDto likeResponseDto) {

        Review review = reviewRepository.findReviewById(likeResponseDto.getReview());
        System.out.println(review);
        LikeReview likeReviewew =new LikeReview(review,likeResponseDto.getUser());
        likeRepository.save(likeReviewew);
    }

    public void deleteLike(LikeResponseDto likeResponseDto) {
        LikeReview likeReview =likeRepository.findLikeReviewByReviewIdAndUser(likeResponseDto.getReview(),likeResponseDto.getUser());
        likeRepository.delete(likeReview);

    }


}

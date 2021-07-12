package com.hanghae.cinema.service;

import com.hanghae.cinema.model.Review;
import com.hanghae.cinema.repository.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public Page<Review> getReview(String moviecode, int page, int size) {


        Pageable pageable = PageRequest.of(page, size);
        return reviewRepository.findReviewByMoviecodeOrderByCreatedAtDesc(moviecode,pageable);
    }
}

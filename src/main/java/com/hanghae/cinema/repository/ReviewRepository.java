package com.hanghae.cinema.repository;


import com.hanghae.cinema.model.LikeReview;
import com.hanghae.cinema.model.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ReviewRepository extends JpaRepository<Review,Long> {
    Page<Review> findReviewByMoviecodeOrderByCreatedAtDesc(String moviecode, Pageable pageable);

    Review findReviewById(Long review_id);
}


package com.hanghae.cinema.repository;


import com.hanghae.cinema.model.LikeReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository  extends JpaRepository<LikeReview, Long > {

    LikeReview findLikeReviewByReviewIdAndUser(Long review_id, String user);


}

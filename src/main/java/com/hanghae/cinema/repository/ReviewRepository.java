package com.hanghae.cinema.repository;



import com.hanghae.cinema.model.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface ReviewRepository extends JpaRepository<Review,Long> {
    List<Review> findByMidOrderByCreatedAtDesc(Long id);


}


package com.hanghae.cinema.repository;

import com.hanghae.cinema.model.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository  extends JpaRepository<Like, Long > {


}

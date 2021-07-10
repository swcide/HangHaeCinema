package com.hanghae.cinema.repository;

import com.hanghae.cinema.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie , Long > {
}

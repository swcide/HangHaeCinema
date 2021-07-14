package com.hanghae.cinema;

import com.hanghae.cinema.service.MovieService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class HangHaeCinemaApplication {


    public static void main(String[] args) {
        SpringApplication.run(HangHaeCinemaApplication.class, args);


    }

}

package com.hanghae.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(name = "MOVIE_CODE", nullable = false, unique = true)
    private String moviecode;

    @Column(nullable = false)
    private String title;

    @Column(nullable=false)
    private String star;

    @Column(nullable = false)
    private String img;

    public Movie(MovieDto movieDto) {
        this.title = movieDto.getTitle();
        this.star = movieDto.getStar();
        this.img = movieDto.getImg();
//        this.moviecode = movieDto.getMovie_code();
    }
//
    @Column(nullable = false)
    private String genre;
//
//    @Column(nullable = false)
//    private String actor;
//
//    @Column(nullable = false)
//    private String runtime;
//
//    @Column(nullable = false)
//    private String rating;
//
//    @Column(nullable = false)
//    private String director;
//
//    @Column(nullable = false)
//    private String year;
//

//
//    @Column(nullable = false)
//    private String plot;
}

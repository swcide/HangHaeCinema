package com.hanghae.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Movie extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable=false)
    private String star;

    @Column(name = "MOVIE_CODE", nullable = false, unique = true)
    private String moviecode;





    @Column(nullable = false)
    private String img;

    public Movie( String title, String star, String movie_code, String img) {
        this.title=title;
        this.star=star;
        this.moviecode = movie_code;
        this.img =img;
    }


//    @Column(nullable = false)
//    private String genre;
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

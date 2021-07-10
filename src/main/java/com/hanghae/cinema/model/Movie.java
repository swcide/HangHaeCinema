package com.hanghae.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class Movie extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(name = "MOVIE_CODE", nullable = false, unique = true)
    private String moviecode;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String genre;

    @Column(nullable = false)
    private String actor;

    @Column(nullable = false)
    private String runtime;

    @Column(nullable = false)
    private String rating;

    @Column(nullable = false)
    private String director;

    @Column(nullable = false)
    private String year;

    @Column(nullable = false)
    private String img;

    @Column(nullable = false)
    private String plot;
}

package com.hanghae.cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class LikeReview {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @JsonIgnore
    @ManyToOne(targetEntity = Movie.class,fetch =FetchType.LAZY)
    @JoinColumn(name="movie_id")
    private Review review;

    @Column(nullable = false)
    private String user;


//    @ManyToOne
//    @JoinColumn(nullable = false, name = "review_id")

//    public LikeReview(LikeDto likeDto) {
//        this.review = likeDto.getReview();
//        this.user =likeDto.getUser();
//
//    }
    public LikeReview(Review review, String user) {
        this.review = review;
        this.user =user;

    }
}

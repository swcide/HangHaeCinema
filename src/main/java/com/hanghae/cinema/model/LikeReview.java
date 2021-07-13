package com.hanghae.cinema.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.hanghae.cinema.dto.LikeDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.http.ResponseEntity;

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
    @ManyToOne
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

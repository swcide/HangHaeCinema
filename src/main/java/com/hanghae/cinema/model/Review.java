package com.hanghae.cinema.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Review extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(name = "REVIEW_CODE", nullable = false, unique = true)
    private String reviewcode;

    @ManyToOne
    @JoinColumn(name = "MOVIE_CODE", referencedColumnName = "MOVIE_CODE")
    private Movie movie;

    @ManyToOne
    @JoinColumn(name = "USER_CODE", referencedColumnName = "USER_CODE")
    private User user;

    @Column(nullable = true)
    private String contents;

    @ColumnDefault("0")
    @Column(nullable = true)
    private int likecount;

    // 김진태 님 탓 ㅇㅈ?
}

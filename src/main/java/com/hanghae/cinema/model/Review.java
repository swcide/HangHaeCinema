package com.hanghae.cinema.model;

import com.hanghae.cinema.dto.ReviewDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
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

//    @ManyToOne
//    @JoinColumn(name = "MOVIE_CODE", referencedColumnName = "MOVIE_CODE")
    @Column(nullable = false)
    private String moviecode;

    @Column(nullable = true)
    private String contents;

    @ColumnDefault("0")
    @Column(nullable = true)
    private int likecount;

    public Review(ReviewDto reviewDto) {
        this.moviecode= reviewDto.getMoviecode();
        this.contents = reviewDto.getContents();
        this.likecount =reviewDto.getLikecount();

    }

    // 김진태 님 탓 ㅇㅈ?
}

package com.hanghae.cinema.model;

import com.hanghae.cinema.dto.request.ReviewRequestDto;
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

    @Column(nullable =false)
    private Long moviveid;


    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String contents;

    @Column(nullable = false)
    private String password;






    public Review(ReviewRequestDto reviewDto) {

        if (reviewDto.getContents() == "") {
            throw new ArithmeticException("내용이 비어있어요!");
        }

        this.username = reviewDto.getUsername();
        this.moviveid = reviewDto.getMoviveid();
        this.contents = reviewDto.getContents();
        this.password = reviewDto.getPassword();


    }

    public void updateReview(ReviewRequestDto reviewDto) {
        this.username = reviewDto.getUsername();
        this.contents = reviewDto.getContents();
    }

    // 김진태 님 탓 ㅇㅈ?
}

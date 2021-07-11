package com.hanghae.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Like extends Timestamped{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(nullable = false, name = "review_id")
    private Review review;

    @ManyToOne
    @JoinColumn(name = "USER_CODE", referencedColumnName = "USER_CODE")
    private User user;

//    @ColumnDefault("false")
//    @Column()
//    private boolean islike = false;



}

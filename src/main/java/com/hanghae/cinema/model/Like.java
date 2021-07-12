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

//    @ManyToOne
//    @JoinColumn(nullable = false, name = "review_id")
//    private Review review;


//    @ColumnDefault("false")
//    @Column()
//    private boolean islike = false;



}

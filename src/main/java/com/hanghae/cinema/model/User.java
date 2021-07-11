package com.hanghae.cinema.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@NoArgsConstructor
@Entity
public class User extends Timestamped {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    @Column(name = "USER_CODE", nullable = false, unique = true)
    private String email;



    @Column(nullable = false)
    private String password;

    @Column(nullable = true)
    private String kakaoid;

    @Column(nullable = false)
    private String nickname;



    public User(String email, String password, String nickname) {
        this.email = email;
        this.password = password;
        this.kakaoid = null;
        this.nickname = nickname;
    }
}
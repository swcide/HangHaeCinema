package com.hanghae.cinema.controller;

import com.hanghae.cinema.dto.LikeResponseDto;
import com.hanghae.cinema.model.LikeReview;
import com.hanghae.cinema.repository.LikeRepository;
import com.hanghae.cinema.service.LikeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class LikeController {

    final LikeService likeService;
    final LikeRepository likeRepository;

    @GetMapping("/api/like")
        public List<LikeReview> getMoives()  {
        System.out.println("호출 몇번됩니까?");
        List<LikeReview> lr =  likeRepository.findAll();

        return lr;
    }

    @PostMapping("/api/like")
    public String clickLike(@RequestBody LikeResponseDto likeResponseDto){
        likeResponseDto.setUser("zz");

        System.out.println(likeResponseDto.getReview());
        System.out.println(likeResponseDto.getUser());
        likeService.clickLike(likeResponseDto);
        return "like";
    }

    @DeleteMapping("/api/like")
    public String deleteLike(@RequestBody LikeResponseDto likeResponseDto){

        likeService.deleteLike(likeResponseDto);
        return "delete";
    }

}

package com.hanghae.cinema.controller;

import com.hanghae.cinema.dto.request.LikeRequestDto;
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
        List<LikeReview> lr =  likeRepository.findAll();
        return lr;
    }

    @PostMapping("/api/like")
    public String clickLike(@RequestBody LikeRequestDto likeResponseDto){

        System.out.println(likeResponseDto.getUserName());
        System.out.println(likeResponseDto.getReviewId());
        System.out.println(likeResponseDto.getReviewId().getClass());

        likeService.clickLike(likeResponseDto);

        return "like";
    }

    @DeleteMapping("/api/like")
    public String deleteLike(@RequestBody LikeRequestDto likeResponseDto){
        likeService.deleteLike(likeResponseDto);
        return "delete";
    }

}

package com.hanghae.cinema.util;


import com.hanghae.cinema.dto.CrawlingDto;

import com.hanghae.cinema.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RequiredArgsConstructor
@Component
public class MovieCrawling {
    private final MovieService movieService;


    // 서버 실행과 동시에 크롤링 하겠다.
//    @PostConstruct
    public List<CrawlingDto> movieListcrawling() throws Exception{
        String url = "https://movie.naver.com/movie/running/current.nhn";
        Document doc = Jsoup.connect(url).get();
        Elements element = doc.select("dl.lst_dsc");
        String img ="https://movie.naver.com/movie/bi/mi/photoViewPopup.nhn?movieCode=204496";
        return movieService.saveMovies(getimgList(toList(element,img)));
    }

    public  List<CrawlingDto>  getimgList(List<CrawlingDto> crawlingDto)throws Exception {

        List<String> imgList = new ArrayList<>();
        List<CrawlingDto> result = crawlingDto;

        for(CrawlingDto  craw: crawlingDto) {
            String code = craw.getMovie_Code();
            String url = "https://movie.naver.com/movie/bi/mi/photoViewPopup.nhn?movieCode=" + code;
            Document doc = Jsoup.connect(url).get();
            Elements element = doc.select("#targetImage");
            String img =element.attr("src");
            imgList.add(img);
        }
        for (int i = 0; i <result.size() ; i++) {
            result.get(i).setImg(imgList.get(i));
            System.out.println(result.get(i));
        }

        return result;
    }



    public List<CrawlingDto> toList(Elements element,String img) {
        return element
                .stream()
                .map(el->new CrawlingDto(
                        el.select(".tit>a").text(),
                        el.select("dd.star > dl.info_star > dd > div > a > span.num").text(),
                        el.select(".tit>a").attr("href").split("code="),
                        img
                )).collect(Collectors.toList());

    }
}

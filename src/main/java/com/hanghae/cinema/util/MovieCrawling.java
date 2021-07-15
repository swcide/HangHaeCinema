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

        return movieService.saveMovies(getimgList(toList(element)));
    }

    public  List<CrawlingDto>  getimgList(List<CrawlingDto> crawlingDto)throws Exception {

        List<String> imgList = new ArrayList<>();
        List<String> plotList = new ArrayList<>();
        List<CrawlingDto> result = crawlingDto;

        for(CrawlingDto  craw: crawlingDto) {
            String code = craw.getMovie_Code();
            String url = "https://movie.naver.com/movie/bi/mi/photoViewPopup.nhn?movieCode=" + code;
            Document doc = Jsoup.connect(url).get();
            Elements element = doc.select("#targetImage");
            String img =element.attr("src");
            imgList.add(img);
        }

        for(CrawlingDto  craw2: crawlingDto) {
            String code = craw2.getMovie_Code();
            String url = "https://movie.naver.com/movie/bi/mi/basic.nhn?code=" + code;
            Document doc = Jsoup.connect(url).get();
            Elements element = doc.select("div.section_group_frst");
            String plot =element.select("div:nth-child(1) > div > div.story_area > p").text();

//            System.out.println("plot = "+plot);
            plotList.add(plot);

        }

        for (int i = 0; i <result.size() ; i++) {
            result.get(i).setImg(imgList.get(i));
            result.get(i).setPlot(plotList.get(i));
//            System.out.println(result.get(i));
        }
        System.out.println("-------result--------");
        System.out.println(result);
        return result;
    }

    public List<CrawlingDto> toList(Elements element) {
        return element
                .stream()
                .map(el->new CrawlingDto(
                        el.select(".tit>a").text(),
                        el.select("dd.star > dl.info_star > dd > div > a > span.num").text(),
                        el.select(".tit>a").attr("href").split("code="),
                        null,
                        null
                )).collect(Collectors.toList());

    }
}

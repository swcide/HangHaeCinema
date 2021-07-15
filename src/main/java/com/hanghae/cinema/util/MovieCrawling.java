package com.hanghae.cinema.util;


import com.hanghae.cinema.dto.request.CrawlingDto;

import com.hanghae.cinema.service.MovieService;
import lombok.RequiredArgsConstructor;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class MovieCrawling {
    private final MovieService movieService;
//     서버 실행과 동시에 크롤링 하겠다.
//    @PostConstruct
    public List<CrawlingDto> movieListcrawling() throws Exception{
        String url = "https://movie.naver.com/movie/running/current.nhn";
        Document doc = Jsoup.connect(url)
                .userAgent("Mozilla/5.0 (compatible; 008/0.83; http://www.80legs.com/webcrawler.html) Gecko/2008032620")
                .get();
        Elements element = doc.select("dl.lst_dsc");

        return movieService.saveMovies(getimgList(toList(element)));
    }

    public List<CrawlingDto> toList(Elements element) {
        return element
                .stream()
                .map(el->new CrawlingDto(
                        el.select(".tit>a").text(),
                        el.select("dd.star > dl.info_star > dd > div > a > span.num").text(),
                        el.select(".tit>a").attr("href").split("code="),
                        null,
                        null,
                        el.select("dd:nth-child(3) > dl > dd:nth-child(2) > span.link_txt > a").text(),
                        null,
                        null,
                        el.select("dd:nth-child(3) > dl > dd:nth-child(6) > span > a").text()

                )).collect(Collectors.toList());
    }

    public List<CrawlingDto>  getimgList(List<CrawlingDto> crawlingDto)throws Exception {
        List<String> imgList = new ArrayList<>();
        List<String> plotList = new ArrayList<>();
        List<String> yearList = new ArrayList<>();
        List<String> runtimeList = new ArrayList<>();

        // 이미지
        for(CrawlingDto  craw: crawlingDto) {
            String code = craw.getMovie_Code();
            String url = "https://movie.naver.com/movie/bi/mi/photoViewPopup.nhn?movieCode=" + code;
            Document doc = Jsoup.connect(url).get();
            Elements element = doc.select("#targetImage");
            String img =element.attr("src");
            imgList.add(img);
        }
        // 플롯
        for(CrawlingDto  craw: crawlingDto) {
            String code = craw.getMovie_Code();
            String url = "https://movie.naver.com/movie/bi/mi/basic.nhn?code=" + code;
            Document doc = Jsoup.connect(url).get();
            Elements element = doc.select("div.section_group_frst");
            String plot =element.select("div:nth-child(1) > div > div.story_area > p").text();
            plotList.add(plot);
        }
        //개봉일
        for(CrawlingDto  craw: crawlingDto) {
            String code = craw.getMovie_Code();
            String url = "https://movie.naver.com/movie/bi/mi/basic.naver?code=" + code;
            Document doc = Jsoup.connect(url).get();
            Elements element = doc.select("div.mv_info");
            String year =element.select("dl > dd:nth-child(2) > p > span:nth-child(4) > a:nth-child(1)").text();
            String day = element.select("dl > dd:nth-child(2) > p > span:nth-child(4) > a:nth-child(2)").text();
            yearList.add(year+day);
        }

        // 러닝타임
        for(CrawlingDto  craw: crawlingDto) {
            String code = craw.getMovie_Code();
            String url = "https://movie.naver.com/movie/bi/mi/basic.naver?code=" + code;
            Document doc = Jsoup.connect(url).get();
            Elements element = doc.select("div.mv_info");
            String runtime =element.select("dl > dd:nth-child(2) > p > span:nth-child(3)").text();
            runtimeList.add(runtime);
        }



        for (int i = 0; i < crawlingDto.size() ; i++) {
            crawlingDto.get(i).setImg(imgList.get(i));
            crawlingDto.get(i).setPlot(plotList.get(i));
            crawlingDto.get(i).setYear(yearList.get(i));
            crawlingDto.get(i).setRuntime(runtimeList.get(i));
        }
        return crawlingDto;
    }
}

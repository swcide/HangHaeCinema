package com.hanghae.cinema.controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @RequestMapping("/crawling")
    public String crawling() throws Exception{
        String url = "https://movie.naver.com/movie/running/current.nhn";

        System.out.println("---------현재상영영화----------");
        System.out.println("url : " + url);

        Document doc = Jsoup.connect(url).get();

        Elements element = doc.select("div.lst_wrap");

        // title
        for(Element el : element.select(".tit >a")){
            System.out.println(el.text());
        }

        // genre





//        String title = element.select(".tit > a").text();

//        System.out.println("title :" + title);
        System.out.println("====================");

        return "@@@";

    }
}

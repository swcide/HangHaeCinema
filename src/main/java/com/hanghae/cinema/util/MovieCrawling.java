package com.hanghae.cinema.util;


import com.hanghae.cinema.model.Movie;
import com.hanghae.cinema.model.MovieDto;
import org.json.JSONArray;
import org.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MovieCrawling {


    @RequestMapping("/crawling")
    public List<MovieDto> crawling() throws Exception{
        String url = "https://movie.naver.com/movie/running/current.nhn";

        System.out.println("---------현재상영영화----------");
        System.out.println("url : " + url);

        Document doc = Jsoup.connect(url).get();
        Elements element = doc.select("div.lst_wrap");

        List<MovieDto> title = new ArrayList<>();



        for (int i = 0; i <title.size() ; i++) {

            Movie m = new Movie(title);
        }
//        HashMap<String,String> title = new HashMap<>();
        // title
//        for(Element el : element.select(".tit >a")){
//            System.out.println(el.text());
//        }
        // genre
//        String title = element.select(".tit > a").text();

//        System.out.println("====================");
//        title.put("title",element.select(".tit >a").text());


//        JSONObject rjson = new JSONObject();
//        JSONArray movies  = rjson.getJSONArray("title");
//        List<MovieDto> ret = new ArrayList<>();


        return element.text();

    }




    public List<MovieDto> fromJSONtoMovies(String result) {
        JSONObject rjson = new JSONObject(result);
        JSONArray movies  = rjson.getJSONArray("title");
        List<MovieDto> ret = new ArrayList<>();
        for (int i=0; i<movies.length(); i++) {
            JSONObject movieJson = (JSONObject) movies.get(i);
            MovieDto movieDto = new MovieDto(movieJson);
            ret.add(movieDto);
        }
        return ret;
    }
}
